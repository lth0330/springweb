package cross.service;


import cross.dto.TaskDto;
import cross.entity.TaskEntity;
import cross.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class TaskService {

    private final TaskRepository taskRepository;

    // [1] 등록
    public TaskDto 등록(TaskDto taskDto){
        return taskRepository.save(taskDto.toEntity()).toDto();
    }

    // [2] 전체조회
    public List<TaskDto> 전체조회(){
        return taskRepository.findAll().stream().map(TaskEntity::toDto).collect(Collectors.toList());   // 한 번 다시
    }

    // [3] 업무 요청 상세 조회
    public TaskDto getTaskDetail(int id){
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow();
        return taskEntity.toDto();
    }

    // [4] 업무 요청 수정
    @Transactional
    public TaskDto updateTask(int id, TaskDto request){
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow();
        taskEntity.setTitle(request.getTitle());
        taskEntity.setContent(request.getContent());
        taskEntity.setStatus(request.getStatus());
        return taskEntity.toDto();
    }

    // [5] 업무 요청 삭제
    public void deleteTask(int id){
        TaskEntity task = taskRepository.findById(id).orElseThrow();
        taskRepository.delete(task);
    }
}
