package com.example.Team.service;

import com.example.Team.dto.response.TeamDto;
import com.example.Team.dto.requestTeam.CreateTeamRequest;
import com.example.Team.dto.requestTeam.UpdateTeamRequest;
import com.example.Team.entity.Team;
import com.example.Team.enums.ErrorCodeEnum;
import com.example.Team.exception.TeamNotFoundException;
import com.example.Team.repository.TeamRepository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService implements TeamServiceInter{

    private final  TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createTeam(CreateTeamRequest createTeamRequest) {
        Team team=Team.builder()
                .name(createTeamRequest.getName())
                .build();
        teamRepository.save(team);
    }

    @Override
    public TeamDto findById(int id) {
        try {
            Team team = teamRepository.findById(id);
            TeamDto teamDto = modelMapper.map(team,TeamDto.class);
            return teamDto;
        }catch (NullPointerException e){
            throw new TeamNotFoundException(ErrorCodeEnum.TEAM_NOT_FOUND);
        }
        catch (IllegalArgumentException e){
            throw new TeamNotFoundException(ErrorCodeEnum.TEAM_NOT_FOUND);
        }

    }

    @Override
    public void deleteTeam(int id) {
        Team team=teamRepository.findById(id);
        teamRepository.delete(team);
    }

    @Override
    public TeamDto updateTeam(int id, UpdateTeamRequest updateTeamRequest) {
        Team team=teamRepository.findById(id);
        team.setName(updateTeamRequest.getName());

        teamRepository.save(team);
        return modelMapper.map(team,TeamDto.class);
    }

    @Override
    public List<TeamDto> getAll() {
        List<Team> list=teamRepository.findAll();
        return list.stream().map(teamEntity->modelMapper.map(teamEntity,TeamDto.class))
                .collect(Collectors.toList());
    }
}
