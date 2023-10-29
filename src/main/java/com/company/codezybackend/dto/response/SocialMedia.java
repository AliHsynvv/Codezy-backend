package com.example.Team.dto.response;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocialMedia implements Serializable{
    int Id;
    String Instagram;
    String Facebook;
    String X;
    String Linkedln;
}
