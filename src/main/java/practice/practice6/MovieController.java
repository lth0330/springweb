package practice.practice6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired MovieService movieService;

/*
    // 등록
    @PostMapping
    public boolean 영화등록(@RequestBody MovieDto movieDto){
        boolean result = movieService.영화등록(movieDto);
        return result;
    }

    // 전체 조회
    @GetMapping("/all")
    public List<MovieDto> 전체조회(){
        List<MovieDto> result = movieService.영화전체조회();
        return result;
    }


    // 조회
    @GetMapping
    public MovieDto 영화조회(int mno){
        MovieDto result = movieService.영화조회(mno);
        return result;
    }

    // 삭제
    @DeleteMapping
    public boolean 영화삭제(int mno){
        boolean result = movieService.영화삭제(mno);
        return result;
    }

    // 수정
    @PutMapping
    public MovieDto  영화수정(@RequestBody MovieDto movieDto){
        MovieDto result = movieService.영화수정(movieDto);
        return result;
    }
*/
}
