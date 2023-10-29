package com.example.Team.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Configuration;


    @Configuration
    public class ModelMapperConfig{

        @Bean
        public ModelMapper getModelMapper(){
            ModelMapper modelMapper=new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return modelMapper;

    }
}
