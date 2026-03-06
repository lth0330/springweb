package example.종합.예제10.board.service;


import example.종합.예제10.board.dto.BoardDto;
import example.종합.예제10.board.entity.BoardEntity;
import example.종합.예제10.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    //  서비스는 http를 담당하지 않는다.

    // 게시물 등록
    public boolean 등록(BoardDto boardDto){
        //  1. 저장할 dto --> entity를 변환한다.
        BoardEntity saveEntity = boardDto.toEntity();

        // 2. JPA 이용한 entity 저장
        saveEntity = boardRepository.save(saveEntity);

        // 3. PK 생성여부 판단
        if (saveEntity.getBno() >= 1) return true;
        return false;
    }

    // 게시물 전체 조회
    public List<BoardDto> 전체조회(){
        // 1. JPA를 이용한 모든 앤티티 조회
        List<BoardEntity> entityList = boardRepository.findAll();
        List<BoardDto> list = new ArrayList<>();
        // 2. 조회된 모든 앤티티 --> dto 변환
        entityList.forEach(entity ->{    // 리스트변수명.forEach(반복변수 -> {실행문;}
            BoardDto boardDto = entity.toDto(); // 3. 앤티티 하나씩 dto 변환
            list.add(boardDto); // 4. 새로운 리스트에 담기
        });
        // 5. 새로운 리스트 반환
        return list;
    }


    // 게시물 조회(1개)
    public BoardDto 조회(int bno){
        // 1. 조회할 번호(pk/id)의 앤티티 찾기
        Optional<BoardEntity> optional = boardRepository.findById(bno);
        // 2. 만약에 앤티티가 존재하면
        if (optional.isPresent()){
            BoardEntity entity = optional.get();
            BoardDto boardDto  = entity.toDto();// 3. 앤티티를 Dto로 변환
            
            // 4. 반환
            return boardDto; // 조회 성공
        }
        return null;  // 조회 실패
    }
}
