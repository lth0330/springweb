package study.day06;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@MappedSuperclass
@Getter

public class BaseTime {

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
