package com.example.relationaldatabase.onetoone.bidirectionaljointable;

import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL)
    private WorkStation workStation;

}
