package cross.controller;


import cross.dto.TaskDto;
import cross.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/task")
@CrossOrigin(origins = "http://localhost:5173") // 서로 다른 port(프로그램식별번호) 간의 통신 허용
// SOP 정책으로 서로 다른 도메인은 통신이 불가능하다. ( HTTP 보안 정책 )
//CORS : 교차 출처 리소스 공유, 즉] 서로 다른 도메인(8080 : 스프링, 5173 : 리액트) 통신 공유 허용
public class TaskController {

    private final TaskService taskService;

    // [1] 등록
    @PostMapping
    public ResponseEntity<?> 등록(@RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.등록(taskDto));
    }

    // [2] 전체 조회
    @GetMapping
    public ResponseEntity<?> 전체조회() {
        return ResponseEntity.ok(taskService.전체조회());
    }

    // [3] 업무 요청 상세 조회
    @GetMapping("/detail")
    public ResponseEntity<?> getTaskDetail(@RequestParam int id) {
        return ResponseEntity
                .ok(taskService.getTaskDetail(id));
    }

    // [4] 업무 요청 수정
    @PutMapping
    public ResponseEntity<?> updateTask(@RequestParam int id, @RequestBody TaskDto request) {
        return ResponseEntity
                .ok(taskService.updateTask(id, request));
    }

    // [5] 업무 요청 삭제
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam int id) {
        taskService.deleteTask(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
