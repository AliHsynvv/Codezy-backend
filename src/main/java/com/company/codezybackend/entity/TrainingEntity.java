package com.company.codezybackend.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.swing.*;
import java.awt.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String icon;
    String time;
    String name;

}
