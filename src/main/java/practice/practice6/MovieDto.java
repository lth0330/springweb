package practice.practice6;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.day06.GoodsEntity;

@AllArgsConstructor@NoArgsConstructor@Data@Builder


public class MovieDto {

    private Integer mno;
    private String mtitle;
    private String director;
    private String mopen;
    private String mrating;

    private String crateDate;
    private String updateDate;


    public MovieEntity toEntity(){
        return MovieEntity.builder()
                .mno(mno)
                .mtitle(mtitle)
                .director(director)
                .mopen(mopen)
                .mrating(mrating).build();
    }
}
