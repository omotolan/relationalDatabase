package com.example.relationaldatabase.onetoone.bidirectional;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    @NonNull
    private UserRepository userRepository;

    @Override
    public String addUser(AddUserRequest addUserRequest) {
        User user = User.builder()
                .lastName(addUserRequest.getLastName())
                .firstName(addUserRequest.getFirstName())
                .address(addUserRequest.getAddress())
                .build();

        User savedPerson = userRepository.save(user);
        return savedPerson.getFirstName() + " saved";
    }

    @Override
    public String deleteUser(long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(value -> userRepository.delete(value));
        return "deleted";
    }
}
