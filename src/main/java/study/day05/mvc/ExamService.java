package study.day05.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    // C : 쓰기 insert
    public boolean 저장(ExamDto examDto){
        // insert 대신에 JPA 함수 사용
        // .save(앤티티) : 해당 앤티티를 insert 한다.
        // 1] 저장할 DTO --> Entity 변환
        ExamEntity examEntity = new ExamEntity();
        examEntity.setEname(examDto.getEname());
        // 2] .save 이용한 insert 하고 처리한 entity 반환, pk 여부
        ExamEntity savedEntity = examRepository.save(examEntity);
        // 3] 처리한  entity 의 pk(primary key) 여부
        if(savedEntity.getEno() >= 1)return true; // pk가 1보다 크면 성공
        return false;
    }
    // D : 삭제 delete
    public boolean 삭제(int eno){
        // delete 대신에 JPA 함수 사용
        // .deleteByID(삭제할 PK번호)
        examRepository.deleteById(eno);
        return true;
    }

    // U : 수정 update
    public boolean 수정(ExamDto examDto){
        // update 대신에 JPA 영속성 사용한다.
        // 데이터베이스와 자바객체 연결되는 상태를 계속적으로 유지
        // 즉 자바객체가 수정되면 데이터베이스도 자동 수정
        // 1] 수정할 entity 찾기 , PK
         Optional< ExamEntity > optional =
                 examRepository.findById(examDto.getEno());   //findById(수정할 pK 번호);
        // 2] 만약에 entitiy가 존자하면 , . isPresent() : 조회 결과가 있으면 true , 없으면 false 반환 함수
        if(optional.isPresent()){
            ExamEntity examEntity = optional.get(); //존재한 앤티티 꺼내기
            // ************************ 영속성 이용한 수정 *************************//
            examEntity.setEname(examDto.getEname()); // 입력받은(수정할) 값을 앤티티에 setter을 이용하여 수정.
            return true;
        }
    return false;
    }
}
