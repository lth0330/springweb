package practice.practice6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
/*
    // 등록
    public boolean 영화등록(MovieDto movieDto){
        MovieEntity saved = movieRepository.save(movieDto.toEntity());

        if (saved.getMno()>=1) return true;
        return false;
    }

    // 전체 조회
    public List<MovieDto> 영화전체조회(){
        List<MovieEntity> movieEntityList = movieRepository.findAll();
        List<MovieDto> movieDtoList = new ArrayList<>();
        movieEntityList.forEach(entity ->{
           MovieDto movieDto = new MovieDto();

        });

    }

    // 조회
    public MovieDto 영화조회(int mno){

    }

    // 삭제
    public boolean 영화삭제(int mno){

    }

    // 수정
    public MovieDto 영화수정(MovieDto movieDto){

    }
    */

}
