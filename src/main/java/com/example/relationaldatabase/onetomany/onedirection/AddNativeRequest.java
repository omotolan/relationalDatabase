package com.example.relationaldatabase.onetomany.onedirection;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AddNativeRequest {
    private String firstName;
    private String lastName;
    private  Cohort cohort;
}
