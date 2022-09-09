package com.example.relationaldatabase.onetoone.onedirection;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AddPersonRequest {
    private String firstName;
    private String lastName;
    private Address address;
}
