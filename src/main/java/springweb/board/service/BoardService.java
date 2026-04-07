package springweb.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import springweb.board.dto.BoardDto;
import springweb.board.entity.BoardEntity;
import springweb.board.repository.BoardRepository;
import springweb.member.entity.MemberEntity;
import springweb.member.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;    // + 회원리포지토리
    private final FileService fileService;  // +파일 서비스


    // [1] 글쓰기
    public boolean write(BoardDto boardDto, String loginMid){
        BoardEntity save = boardDto.toEntity();// 1] dto --> entity 변환한다.
        // ******* 저장하기 전에 FK 대입하기, FK의 앤티티를 찾아서 대입 **********
        // 현재 로그인중인 mid로 앤티티 찾기
        Optional<MemberEntity> entityOptional = memberRepository.findByMid(loginMid);
        if (!entityOptional.isPresent()) { // ! 부정문
            return false;   // 존재하지않은 회원으로 실패
        }

        // 저장할 게시물 앤티티에 set 참조 앤티티 (회원앤티티;
        save.setMemberEntity(entityOptional.get());

        // ============ 최종 DB에 앤티티를 SAVE 하기 전에 첨부파일이 존재하면 업로드 하기 =============
        String fileName = fileService.upload(boardDto.getUploadFile());   // dto 내 multipartFile 대입한다.

        // 만약에 업로드 했다면 저장할 앤티티에 파일명 정하기
        if (fileName != null){save.setBfile(fileName);}

        BoardEntity saved = boardRepository.save(save); // 2) entity 저장한다.
        if (saved.getBno()>0){return true;}
        return false;
    }


    public List<BoardDto> findAll(){
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "bno")) // .findAll(페이징, 정렬) 전체조회
                .stream()   // stream 이란 여러개 자료를 갖는 자료 (리스트/ 배열)들의 순차적 처리 지원 함수
                // .map(boardEntity -> {return boardEntity.toDto();})
                .map( BoardEntity :: toDto) // 메소드 레퍼런스란, 화살표 ㅏㅁ수 간결하게 사용하는 문법, 클래스명 :: 함수명
                .toList();  // 리스트타입으로 변환
    }

    public BoardDto findById( Long bno){
        return boardRepository.findById(bno)   // .findById( pk 번호 ) 개별앤티티 조회
                .orElse(null)   // 만일 엔티티가 없으면
                .toDto();   // 앤티티가 존재하면 dto로 변환
    }
}
