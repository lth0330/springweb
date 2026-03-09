package practice.practice7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.practice7.Dto.EnrollDto;
import practice.practice7.Entity.EnrollEntity;
import practice.practice7.repository.EnrollRepository;

import java.util.List;

@Service
public class EnrollService {

    @Autowired
    private EnrollRepository enrollRepository;

    public boolean 수강등록(EnrollDto enrollDto){
        EnrollEntity enrollEntity = enrollDto.toEntity();
        EnrollEntity saved = enrollRepository.save(enrollEntity);

        if (saved.getEnrollId()>=1)return true;
        return false;
    }
/*
    public List<EnrollDto> 수강조회(){

    }
*/
}
