package com.example.relationaldatabase.onetoone.bidirectionaljointable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String laptop;
    private String monitor;
    @OneToOne(mappedBy = "workStation")
    private Employee employee;
}
