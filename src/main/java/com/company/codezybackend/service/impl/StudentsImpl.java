package com.company.codezybackend.service.impl;

import com.company.codezybackend.dto.StudentsEntityDto;
import com.company.codezybackend.entity.StudentsEntity;
import com.company.codezybackend.enums.ErrorCodeEnum;
import com.company.codezybackend.exception.StudentsException;
import com.company.codezybackend.repository.StudentsRepo;
import com.company.codezybackend.service.inter.StudentsInter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentsImpl implements StudentsInter {
    private final StudentsRepo studentsRepo;
    private final ModelMapper modelMapper;


    @Override
    public void createS(StudentsEntityDto studentsDto) {
        StudentsEntity students = StudentsEntity.builder()
                .studentName(studentsDto.getStudentName())
                .studentSurName(studentsDto.getStudentSurName())
                .studentArea(studentsDto.getStudentArea())
                .studentComment(studentsDto.getStudentComment())
                .build();
        studentsRepo.save(students);
    }

    @Override
    public StudentsEntityDto findByIdS(int id) {
        Optional<StudentsEntity> findS = studentsRepo.findById(id);
        if (findS.isEmpty()) {
            throw new StudentsException(ErrorCodeEnum.STUDENTS_NOT_FOUND);
        }

        return findS.map(studentsE -> modelMapper.map(studentsE, StudentsEntityDto.class)).orElseThrow();
    }

    @Override
    public List<StudentsEntityDto> getAllStudents() {
        List<StudentsEntity> getAllStudents = studentsRepo.findAll();
        if (getAllStudents.isEmpty()) {
            throw new StudentsException(ErrorCodeEnum.NOT_ENOUGH_STUDENTS);
        }
        return getAllStudents.stream()
                .map(trainingE -> modelMapper.map(trainingE, StudentsEntityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        Optional<StudentsEntity> deleteS = studentsRepo.findById(id);
        if (deleteS.isEmpty()) {
            throw new StudentsException(ErrorCodeEnum.STUDENTS_NOT_FOUND);
        } else {
            studentsRepo.deleteById(id);
        }
    }

    @Override
    public StudentsEntity updateS(StudentsEntityDto studentsEntityDto, int id) {
        Optional<StudentsEntity> updateS = studentsRepo.findById(id);
        if (updateS.isPresent()) {
            StudentsEntity newStudents = updateS.get();

            newStudents.setStudentName(studentsEntityDto.getStudentName());
            newStudents.setStudentSurName(studentsEntityDto.getStudentSurName());
            newStudents.setStudentArea(studentsEntityDto.getStudentArea());
            newStudents.setStudentComment(studentsEntityDto.getStudentComment());

            return studentsRepo.save(newStudents);
        }
        throw new StudentsException(ErrorCodeEnum.NOT_ENOUGH_STUDENTS);

    }
}

