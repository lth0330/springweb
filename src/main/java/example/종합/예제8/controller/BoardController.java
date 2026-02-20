package example.종합.예제8.controller;

import example.종합.예제8.model.dao.BoardDao;
import example.종합.예제8.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController  // 해당 컨트롤러는 HTTP웹 기능을 갖게 된다. <싱글톤 유사 포함>
public class BoardController {
 //   private BoardController(){}
 //  private static final BoardController instance = new BoardController();
 //   public static BoardController getInstance(){ return  instance;}

    private BoardDao bd = BoardDao.getInstance();

    @PostMapping
    //[1] 게시물 들록 controller
    public boolean write(String bcontent, String bwriter){
        boolean result = bd.write(bcontent, bwriter);
        return result;
    }
    @GetMapping  // 해당 메소드의 HTTP웹 통신 기능을 갖게 된다.
    // [2] 게시물 전체조회
    public ArrayList<BoardDto> findAll() {
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }
    @PutMapping
    // [3] 게시물 수정 controller
    public boolean update(int bno, String bcontent){
        boolean result = bd.update(bno, bcontent);
        return result;
    }
    @DeleteMapping
    // [4]게시물 삭제 controller
    public boolean delete(int bno){
        boolean result = bd.delete(bno);
        return result;
    }


} // class end