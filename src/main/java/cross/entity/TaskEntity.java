package cross.entity;

import cross.dto.TaskDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springweb.BaseTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
@Table
public class TaskEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String requester;
    private String status;

    public TaskDto toDto() {
        return TaskDto.builder()
                .id(this.id).title(this.title).content(this.content).requester(this.requester).status(this.status)
                .creatDate(getCreateDate().toString()).updateDate(getUpdateDate().toString())
                .build();

    }
}