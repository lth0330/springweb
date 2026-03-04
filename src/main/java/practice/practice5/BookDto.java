package practice.practice5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {
    private Integer bno;
    private String bid;
    private String bname;
    private String bwriter;
    private String bpublisher;
}
