package practice.practice6;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.day06.GoodsDto;

@AllArgsConstructor@NoArgsConstructor@Data@Builder

@Entity
@Table(name="movies")
public class MovieEntity extends MovieBaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mno;

    @Column(nullable = false, unique = true)
    private String mtitle;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String mopen;

    @Column(nullable = false)
    private String mrating;


    public MovieDto toDto(){
        return MovieDto.builder()
                .mno(mno)
                .mtitle(mtitle)
                .director(director)
                .mopen(mopen)
                .mrating(mrating).build();

    }
}
