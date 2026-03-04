package study.day05.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    // R : 조회 select
    public List<ExamDto> 전체조회(){
        // * select 대신에 JPA 함수 사용.
        // findAll : 전체조회
        List<ExamEntity> examEntityList = examRepository.findAll();
        // entity --> dto 변경 < Entity 노출 안하기 >
        List<ExamDto> examDtoList = new ArrayList<>();     // 1) 여러개 dto 저장할 리스트 선언
        examEntityList.forEach(entity ->{        //  2) 반복문 for() vs forEach( 반복변수 -> {실핼문;})
            ExamDto examDto = new ExamDto();                // 3) dto 선언
            examDto.setEno(entity.getEno());                // 4) 반복중인 entity 객체내 맴버변수를 dto에 저장
            examDto.setEname(entity.getEname());            // 5) ""
            examDtoList.add(examDto);                       // 6)  dto를 리스트에 저장
        });
        return examDtoList;             // ** entity가 아닌 dto 반환한다. 왜? 서비스 개발자만 entity다룬다. 왜? 역할과 조작 권한 차이
    }

    // W : 쓰기 insert

    // D : 삭제 delete

    // U : 수정 update

}
