package com.example.Team.dto.requestSocialMedia;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseSocialRequest {

    int Id;
    String Instagram;
    String Facebook;
    String X;
    String Linkedln;
}
