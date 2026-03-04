package practice.practice5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    // 전체 조회
    @GetMapping
    public List<BookDto> 도서전체조회(){
        List<BookDto> result = bookService.도서전체조회();
        return result;
    }

    // 등록
    @PostMapping
    public boolean 도서등록(@RequestBody BookDto bookDto){
        boolean result = bookService.도서등록(bookDto);
        return result;
    }
    // 삭제
    @DeleteMapping
    public boolean 도서삭제(@RequestParam int bno){
        boolean result = bookService.도서삭제(bno);
        return result;
    }
    // 수정
    @PutMapping
    public boolean 도서수정(@RequestBody BookDto bookDto){
        boolean result = bookService.도서수정(bookDto);
        return result;
    }
}
