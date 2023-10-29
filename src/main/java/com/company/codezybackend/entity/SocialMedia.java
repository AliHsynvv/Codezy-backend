package com.example.Team.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocialMedia {
   @Id
    int Id;
    String Instagram;
    String Facebook;
    String X;
    String Linkedln;
}
