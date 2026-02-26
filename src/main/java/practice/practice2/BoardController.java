package practice.practice2;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {
    @PostMapping
    public boolean boardWrite(BoardBto boardBto){

        BoardBto boardBto1 = new BoardBto();

        System.out.println("BoardController.boardWrite");
        return true;
    }

}
