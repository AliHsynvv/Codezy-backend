package com.example.Team.service;

import com.example.Team.dto.response.TeamDto;
import com.example.Team.dto.requestTeam.CreateTeamRequest;
import com.example.Team.dto.requestTeam.UpdateTeamRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamServiceInter {
    void createTeam(CreateTeamRequest createTeamRequest);
    TeamDto findById(int id);
    void deleteTeam(int id);
    TeamDto updateTeam(int id, UpdateTeamRequest updateTeamRequest);
    List<TeamDto> getAll();
}
