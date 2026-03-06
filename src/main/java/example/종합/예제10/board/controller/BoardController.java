package example.종합.예제10.board.controller;

import example.종합.예제10.board.dto.BoardDto;
import example.종합.예제10.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    public boolean 등록(@RequestBody BoardDto boardDto){
        boolean result = boardService.등록(boardDto);
        return result;
    }

    @GetMapping("/all")
    public List<BoardDto> 전체조회(){
        List<BoardDto> boardDtoList = boardService.전체조회();
        return boardDtoList;
    }

    @GetMapping
    public BoardDto 조회(@RequestParam int bno){
        BoardDto result = boardService.조회(bno);
        return result;
    }


}
