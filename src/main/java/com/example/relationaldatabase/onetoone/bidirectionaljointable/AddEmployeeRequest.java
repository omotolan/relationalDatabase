package com.example.relationaldatabase.onetoone.bidirectionaljointable;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AddEmployeeRequest {
    private String firstName;
    private String lastName;
    private WorkStation workStation;
}
