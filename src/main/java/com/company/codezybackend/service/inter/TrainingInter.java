package com.company.codezybackend.service.inter;

import com.company.codezybackend.dto.TrainingEntityDto;
import com.company.codezybackend.entity.TrainingEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface TrainingInter {

    void create(MultipartFile file, TrainingEntityDto trainingDto);

    TrainingEntityDto findById(int id);

    List<TrainingEntityDto> getAllUsers();

    void delete(int id);

    TrainingEntity update(TrainingEntityDto trainingDto, int id);

}
