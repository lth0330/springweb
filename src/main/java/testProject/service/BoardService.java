package testProject.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import testProject.Dto.BoardDto;
import testProject.Dto.DepartmentDto;
import testProject.entity.BoardEntity;
import testProject.entity.DepartmentEntity;
import testProject.repository.BoardRepository;
import testProject.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final DepartmentRepository departmentRepository;

    // 부서 등록
    public boolean departmentPost(DepartmentDto departmentDto) {

        // 빈칸이면 false
        if (departmentDto == null) {
            return false;
        }

        List<DepartmentEntity> list = departmentRepository.findAll();

        // 부서명이 이미 존재하면 false
        for (int i = 0; i < list.size(); i++) {
            DepartmentEntity department = list.get(i);
            if (department.getDName().equals(departmentDto.getDName())) {
                return false;
            }
        }
        DepartmentEntity entity = departmentDto.toEntity();
        departmentRepository.save(entity);

        return true;
    }

    // 부서 전체 조회
    public List<DepartmentDto> departmentGet() {

        List<DepartmentEntity> entityList = departmentRepository.findAll();
        List<DepartmentDto> dtoList = new ArrayList<>();

        for (int i = 0; i < entityList.size(); i++) {
            DepartmentEntity entity = entityList.get(i);
            DepartmentDto dto = entity.toDto();
            dtoList.add(dto);
        }
        return dtoList;
    }

    // 부서 삭제
    public boolean departmentDelete(Long dno) {

        DepartmentEntity entity = departmentRepository.findById(dno).orElse(null);

        if (entity == null) {
            return false;
        }

        departmentRepository.delete(entity);
        return true;
    }

    // 부서 수정
    public boolean departmentUpdate(Long dno, DepartmentDto dto) {

        DepartmentEntity entity = departmentRepository.findById(dno).orElse(null);
        List<DepartmentEntity> list = departmentRepository.findAll();

        // 등록에서 처럼 이미 부서명이 존재하면 false
        for (int i = 0; i < list.size(); i++) {
            DepartmentEntity department = list.get(i);

            if (department.getDName().equals(dto.getDName())) {
                return false;
            }
        }
        entity.setDName(dto.getDName());
        departmentRepository.save(entity);

        return true;
    }

    // ======================================== 사원 ==============================

    // 사원 등록
    public boolean create(BoardDto boardDto) {

        // 빈칸이 존재하면 false
        if (boardDto == null) {
            return false;
        }

        if (boardDto.getName() == null) {
            return false;
        }

        if (boardDto.getPosition() == null) {
            return false;
        }
        if (boardDto.getDName() == null) {
            return false;
        }
        // 부서 찾기
        List<DepartmentEntity> departmentList = departmentRepository.findAll();
        DepartmentEntity findDepartment = null;

        for (int i = 0; i < departmentList.size(); i++) {
            DepartmentEntity department = departmentList.get(i);

            if (department.getDName().equals(boardDto.getDName())) {
                findDepartment = department;
                break;
            }
        }

        // 부서가 없으면 실패
        if (findDepartment == null) {
            return false;
        }

        BoardEntity boardEntity = boardDto.toEntity();
        boardEntity.setDepartmentEntity(findDepartment);

        boardRepository.save(boardEntity);
        return true;
    }

    // 사원 전체 조회
    public List<BoardDto> read() {

        List<BoardEntity> entityList = boardRepository.findAll();
        List<BoardDto> dtoList = new ArrayList<>();

        for (int i = 0; i < entityList.size(); i++) {
            BoardEntity boardEntity = entityList.get(i);
            BoardDto boardDto = boardEntity.toDto();
            dtoList.add(boardDto);
        }
        return dtoList;
    }

    // 사원 삭제
    public boolean delete(Long bno) {

        BoardEntity boardEntity = boardRepository.findById(bno).orElse(null);

        if (boardEntity == null) {
            return false;
        }
        boardRepository.delete(boardEntity);
        return true;
    }

    // 사원 수정
    public boolean update(Long bno, BoardDto boardDto) {

        // 빈칸이 존재하면 false
        if (boardDto == null) {
            return false;
        }
        if (boardDto.getName() == null) {
            return false;
        }
        if (boardDto.getPosition() == null) {
            return false;
        }
        if (boardDto.getDName() == null) {
            return false;
        }
        BoardEntity boardEntity = boardRepository.findById(bno).orElse(null);
        if (boardEntity == null) {
            return false;
        }

        // 부서 찾기
        List<DepartmentEntity> departmentList = departmentRepository.findAll();
        DepartmentEntity findDepartment = null;

        for (int i = 0; i < departmentList.size(); i++) {
            DepartmentEntity department = departmentList.get(i);

            if (department.getDName().equals(boardDto.getDName())) {
                findDepartment = department;
                break;
            }
        }

        boardEntity.setName(boardDto.getName());
        boardEntity.setPosition(boardDto.getPosition());
        boardEntity.setPicture(boardDto.getPicture());
        boardEntity.setDepartmentEntity(findDepartment);

        boardRepository.save(boardEntity);
        return true;
    }

}