package cross.dto;


import cross.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TaskDto {

    private Integer id;
    private String title;
    private String content;
    private String requester;
    private String status;

    private String creatDate;
    private String updateDate;


    public TaskEntity toEntity(){
        return TaskEntity.builder()
                .id(this.id).title(this.title).content(this.content).requester(this.requester).status(this.status)
                .build();
    }
}
