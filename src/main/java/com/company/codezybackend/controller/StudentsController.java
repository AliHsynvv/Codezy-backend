package com.company.codezybackend.controller;

import com.company.codezybackend.dto.StudentsEntityDto;
import com.company.codezybackend.entity.StudentsEntity;
import com.company.codezybackend.service.inter.StudentsInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentsController {
    private final StudentsInter studentsInter;

    @PostMapping("/creates")
    public void createS(@RequestBody StudentsEntityDto studentsEntityDto) {
        studentsInter.createS(studentsEntityDto);

    }

    @GetMapping("/findids/{id}")
    public StudentsEntityDto findByIdS(@PathVariable int id) {
        return studentsInter.findByIdS(id);
    }

    @GetMapping("/getallstudents")
    public List<StudentsEntityDto> getAllStudents() {
        return studentsInter.getAllStudents();
    }

    @DeleteMapping("/deleteS/{id}")
    @Transactional
    public void deleteS(@PathVariable int id) {
        studentsInter.delete(id);
    }

    @PutMapping("/updates/{id}")
    @Transactional
    public StudentsEntity update(@PathVariable int id, @RequestBody StudentsEntityDto studentsEntityDto) {
        return studentsInter.updateS(studentsEntityDto, id);
    }
}
