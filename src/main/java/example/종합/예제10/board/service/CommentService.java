package example.종합.예제10.board.service;

import example.종합.예제10.board.dto.BoardDto;
import example.종합.예제10.board.dto.CommentDto;
import example.종합.예제10.board.entity.BoardEntity;
import example.종합.예제10.board.entity.CommentEntity;
import example.종합.예제10.board.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public boolean 댓글등록(CommentDto commentDto){
        CommentEntity saveEntitiy = commentDto.toEntity();

        saveEntitiy = commentRepository.save(saveEntitiy);

        if (saveEntitiy.getCno()>=1) return true;
        return false;

    }
    public List<CommentDto> 댓글조회(int bno){
        // 1. JPA를 이용한 모든 앤티티 조회
        List<CommentEntity> entityList = commentRepository.findAll();
        List<CommentDto> list = new ArrayList<>();
        // 2. 조회된 모든 앤티티 --> dto 변환
        entityList.forEach(entity ->{
            if (entity.getBno()==bno){
            // 리스트변수명.forEach(반복변수 -> {실행문;}
            CommentDto commentDto = entity.toDto(); // 3. 앤티티 하나씩 dto 변환
            list.add(commentDto);} // 4. 새로운 리스트에 담기
        });
        // 5. 새로운 리스트 반환
        return list;
    }

    // 댓글 수정
    @Transactional
    public boolean 댓글수정(CommentDto commentDto){

        Optional<CommentEntity> optional = commentRepository.findById(commentDto.getCno());

        if (optional.isPresent()){
            CommentEntity updateEntity = optional.get();
            updateEntity.setCcontent(commentDto.getCcontent());
            updateEntity.setCwriter(commentDto.getCwriter());
            return true;
        }
        return false;
    }

    // 댓글 삭제
    public boolean 댓글삭제(int cno){

        boolean exists = commentRepository.existsById(cno);

        if (exists){
            commentRepository.deleteById(cno);
            return true;
        }
        return false;
    }
}
