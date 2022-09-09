package com.example.relationaldatabase.onetoone.bidirectional;

import com.example.relationaldatabase.onetoone.onedirection.AddPersonRequest;

public interface UserService {
    String addUser(AddUserRequest addUserRequest);

    String deleteUser(long id);
}
