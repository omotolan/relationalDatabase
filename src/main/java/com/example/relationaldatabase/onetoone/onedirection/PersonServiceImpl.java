package com.example.relationaldatabase.onetoone.onedirection;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {
    @NonNull
    private PersonRepository personRepository;

    @Override
    public String addPerson(AddPersonRequest addPersonRequest) {
        Person person = Person.builder()
                .lastName(addPersonRequest.getLastName())
                .firstName(addPersonRequest.getFirstName())
                .address(addPersonRequest.getAddress())
                .build();

        Person savedPerson = personRepository.save(person);
        return savedPerson.getFirstName() + " saved";
    }

    @Override
    public String deleteUser(long id) {
        Optional<Person> person = personRepository.findById(id);
        person.ifPresent(value -> personRepository.delete(value));
        return "deleted";
    }
}
