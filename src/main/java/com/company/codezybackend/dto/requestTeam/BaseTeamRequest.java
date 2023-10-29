package com.example.Team.dto.requestTeam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseTeamRequest {
    int id;
    String name;
    String surname;
    String position;
    String soicialMedia;
}
