package com.example.relationaldatabase.onetoone.bidirectional;

import com.example.relationaldatabase.onetoone.onedirection.Address;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AddUserRequest {
    private String firstName;
    private String lastName;
    private BiAddress address;
}
