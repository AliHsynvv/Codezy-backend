package com.company.codezybackend.service.impl;

import com.company.codezybackend.dto.TrainingEntityDto;
import com.company.codezybackend.entity.TrainingEntity;
import com.company.codezybackend.enums.ErrorCodeEnum;
import com.company.codezybackend.exception.TrainingException;
import com.company.codezybackend.repository.TrainingRepo;
import com.company.codezybackend.service.inter.TrainingInter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrainingImpl implements TrainingInter {
    private final TrainingRepo trainingRepo;
    private final ModelMapper modelMapper;


    @Override
    public void create(TrainingEntityDto trainingDto) {
        TrainingEntity training = TrainingEntity.builder()
                .icon(trainingDto.getIcon())
                .time(trainingDto.getTime())
                .name(trainingDto.getName())
                .build();
        trainingRepo.save(training);
    }

    @Override
    public TrainingEntityDto findById(int id) {
        Optional<TrainingEntity> findT = trainingRepo.findById(id);
        if (findT.isEmpty()) {
            throw new TrainingException(ErrorCodeEnum.Training_NOT_FOUND);
        }

        return findT.map(trainingE -> modelMapper.map(trainingE, TrainingEntityDto.class)).orElseThrow();
    }

    @Override
    public List<TrainingEntityDto> getAllUsers() {
        List<TrainingEntity> getAllBooks = trainingRepo.findAll();
        if (getAllBooks.isEmpty()) {
            throw new TrainingException(ErrorCodeEnum.UNKNOWN_ERROR);
        }
        return getAllBooks.stream()
                .map(trainingE -> modelMapper.map(trainingE, TrainingEntityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        Optional<TrainingEntity> deleteT = trainingRepo.findById(id);
        if (deleteT.isEmpty()) {
            throw new TrainingException(ErrorCodeEnum.Training_NOT_FOUND);
        } else {
            trainingRepo.deleteById(id);
        }
    }

    @Override
    public TrainingEntity update(TrainingEntityDto trainingDto, int id) {
        Optional<TrainingEntity> updateT = trainingRepo.findById(id);
        if (updateT.isPresent()) {
            TrainingEntity newTraining = updateT.get();

            newTraining.setIcon(trainingDto.getIcon());
            newTraining.setTime(trainingDto.getTime());
            newTraining.setName(trainingDto.getName());

            return trainingRepo.save(newTraining);
        }
        throw new TrainingException(ErrorCodeEnum.NOT_ENOUGH_Training);

    }
}
