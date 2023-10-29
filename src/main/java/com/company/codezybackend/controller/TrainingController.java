package com.company.codezybackend.controller;

import com.company.codezybackend.dto.TrainingEntityDto;
import com.company.codezybackend.entity.TrainingEntity;
import com.company.codezybackend.service.inter.TrainingInter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {
    private final TrainingInter trainingInter;

    @PostMapping("/create")
    public void create( @RequestParam MultipartFile file, @RequestBody TrainingEntityDto trainingDto) {
        trainingInter.create(file, trainingDto);

    }

    @GetMapping("/findid/{id}")
    public TrainingEntityDto findById(@PathVariable int id) {
        return trainingInter.findById(id);
    }

    @GetMapping("/getalltrainings")
    public List<TrainingEntityDto> getAllTrainings() {
        return trainingInter.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable int id) {
        trainingInter.delete(id);
    }

    @PutMapping("/update/{id}")
    @Transactional
    public TrainingEntity update(@PathVariable int id, @RequestBody TrainingEntityDto trainingDto) {
        return trainingInter.update(trainingDto, id);
    }
}
