package testProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testProject.Dto.BoardDto;
import testProject.Dto.DepartmentDto;
import testProject.service.BoardService;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:5173")
public class DepartmentController {

    private final BoardService boardService;

    // 부서 등록
    @PostMapping
    public ResponseEntity<?> departmentPost(@RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok(boardService.departmentPost(departmentDto));
    }

    // 부서 전체 조회
    @GetMapping
    public ResponseEntity<?> departmentGet(){
        return ResponseEntity.ok(boardService.departmentGet());
    }

    // 부서 삭제
    @DeleteMapping("/{dno}")
    public ResponseEntity<?> departmentDelete(@PathVariable Long dno){
        return ResponseEntity.ok(boardService.departmentDelete(dno));
    }

    // 부서 수정
    @PutMapping("/{dno}")
    public ResponseEntity<?> departmentUpdate(@PathVariable Long dno,
                                              @RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok(boardService.departmentUpdate(dno, departmentDto));
    }

}