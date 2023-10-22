package com.company.codezybackend.service.inter;


import com.company.codezybackend.dto.StudentsEntityDto;
import com.company.codezybackend.entity.StudentsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentsInter {

    void createS(StudentsEntityDto studentsDto);

    StudentsEntityDto findByIdS(int id);

    List<StudentsEntityDto> getAllStudents();

    void delete(int id);

    StudentsEntity updateS(StudentsEntityDto studentsEntityDto, int id);
}
