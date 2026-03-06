package example.종합.예제10.board.controller;

import example.종합.예제10.board.dto.CommentDto;
import example.종합.예제10.board.dto.CommentDto;
import example.종합.예제10.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public boolean 댓글등록(@RequestBody CommentDto commentDto){
        boolean result = commentService.댓글등록(commentDto);
        return result;
    }

    @GetMapping()
    public List<CommentDto> 댓글조회(@RequestParam int bno){
        List<CommentDto> commentDtoList = commentService.댓글조회(bno);
        return commentDtoList;
    }

    @PutMapping
    public boolean 댓글수정(@RequestBody CommentDto commentDto){
        boolean result = commentService.댓글수정(commentDto);
        return result;
    }

    @DeleteMapping
    public boolean 댓글삭제(@RequestParam int cno){
        boolean result = commentService.댓글삭제(cno);
        return result;
    }
}
