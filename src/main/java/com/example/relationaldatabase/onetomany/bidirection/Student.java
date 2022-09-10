package com.example.relationaldatabase.onetomany.bidirection;

import com.example.relationaldatabase.onetomany.onedirection.Cohort;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToOne
    private Class aClass;
}
