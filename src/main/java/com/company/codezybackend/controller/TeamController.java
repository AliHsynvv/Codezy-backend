package com.example.Team.controller;



import com.example.Team.dto.response.TeamDto;
import com.example.Team.dto.requestTeam.CreateTeamRequest;
import com.example.Team.dto.requestTeam.UpdateTeamRequest;
import com.example.Team.service.TeamServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/codezy",method = RequestMethod.PUT)
@RequiredArgsConstructor
public class TeamController {
    private final TeamServiceInter teamServiceInter;

    @PutMapping("/create")
    public void createTeam(@RequestBody CreateTeamRequest team){
        teamServiceInter.createTeam(team);
    }
    @GetMapping("/find/{id}")
    public TeamDto findById(@PathVariable int id){
        return teamServiceInter.findById(id);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteTeam(@PathVariable int id){
        teamServiceInter.deleteTeam(id);
    }

    @PatchMapping("/update/{id}")
    public TeamDto updateTeam(@PathVariable int id, @RequestBody UpdateTeamRequest updateTeamRequest){
        return teamServiceInter.updateTeam(id,updateTeamRequest);
    }
    @GetMapping("/listTeam")
    public List<TeamDto> getAll(){
        return teamServiceInter.getAll();
    }

}
