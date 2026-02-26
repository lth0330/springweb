package practice.practice3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendanceDto {
    private Integer ano;
    private String studentName;
    private String data;
    private String status;
}
