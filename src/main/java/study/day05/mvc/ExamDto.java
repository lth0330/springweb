package study.day05.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExamDto {
    private Integer eno;// int 대신에 Integer
    private String ename;

}

// DTO 이동 객체