package practice.practice2;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/board")
public class BoardController {

    @PostMapping
    public boolean boardWrite(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.boardWrite");
        return true;
    }

    @GetMapping
    public ArrayList<BoardDto> boardPrint(){
    ArrayList<BoardDto> boardDtoArrayList = new ArrayList<>();
    BoardDto boardDto1 = new BoardDto(1,"안녕하세요1","유재석");
    BoardDto boardDto2 = new BoardDto(2,"안녕하세요2", "강호동");
    boardDtoArrayList.add(boardDto1);
    boardDtoArrayList.add(boardDto2);
    return boardDtoArrayList;

    }

    @GetMapping("/detail")
    public BoardDto boardDetail(int bno){
        BoardDto boardDto = new BoardDto(1,"안녕하세요1","유재석");
        return boardDto;
    }

    @DeleteMapping
    public boolean boardDelete(int bno){
        BoardDto boardDto1 = new BoardDto(1,"수정전","사람");
        boardDto1 = new BoardDto();
        System.out.println("boardDto1 = " + boardDto1);
        return true;
    }

    @PutMapping
    public boolean boardUpdate(BoardDto boardDto){
        BoardDto boardDto1 = new BoardDto(1,"수정전","사람");
        boardDto1 = new BoardDto(2,"수정후","사람2");
        System.out.println("boardDto1 수정 = " + boardDto1);
        return true;
    }




}
