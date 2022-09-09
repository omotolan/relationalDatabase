package com.example.relationaldatabase.onetoone.onedirection;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;
}
/*
* auto generation type creates another table in the database to auto increment the id value.
* it has a column 'next value' which determines the value of the next id
* */