package practice.practice6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

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
            movieDtoList.add(movieDto);

        });
        return movieDtoList;
    }

    // 조회
    public MovieDto 영화조회(int mno){
        Optional<MovieEntity> optional = movieRepository.findById(mno);

        if (optional.isPresent()){
            MovieEntity entity = optional.get();
            MovieDto movieDto = entity.toDto();

            return movieDto;
        }
        return null;
    }

    // 삭제
    public boolean 영화삭제(int mno){

        boolean exist = movieRepository.existsById(mno);
        if (exist){
            movieRepository.deleteById(mno);
            return true;
        }
        return false;
    }

    // 수정
    public boolean 영화수정(MovieDto movieDto){

        Optional<MovieEntity> optional = movieRepository.findById(movieDto.getMno());

        if (optional.isPresent()){
            MovieEntity updateEntity = optional.get();
            updateEntity.setDirector(movieDto.getDirector());
            updateEntity.setMopen(movieDto.getMopen());
            updateEntity.setMtitle(movieDto.getMtitle());
            updateEntity.setMrating(movieDto.getMrating());
            return true;
        }
        return false;
    }


}
