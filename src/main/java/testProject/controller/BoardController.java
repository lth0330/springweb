package testProject.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testProject.Dto.BoardDto;
import testProject.service.BoardService;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:5173")
public class BoardController {

    private final BoardService boardService;

    // 사원 등록
    @PostMapping
    public ResponseEntity<?> create(@RequestBody BoardDto boardDto){
        return ResponseEntity.ok(boardService.create(boardDto));
    }
    // 사원 전체 조회
    @GetMapping
    public ResponseEntity<?> create(){
        return ResponseEntity.ok(boardService.read());
    }

    // 사원 삭제
    @DeleteMapping("/{bno}")
    public ResponseEntity<?> delete(@PathVariable Long bno){
        return ResponseEntity.ok(boardService.delete(bno));
    }

    // 사원 수정
    @PutMapping("/{bno}")
    public ResponseEntity<?> update(@PathVariable Long bno,@RequestBody BoardDto boardDto){
        return ResponseEntity.ok(boardService.update(bno, boardDto));
    }
}
