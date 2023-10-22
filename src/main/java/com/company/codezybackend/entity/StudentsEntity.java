package com.company.codezybackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int studentId;


    String studentName;


    String studentSurName;


    String studentArea;


    String studentComment;
}
