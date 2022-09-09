package com.example.relationaldatabase.onetoone.onedirection;

public interface PersonService {
    String addPerson(AddPersonRequest addPersonRequest);

    String deleteUser(long id);
}
