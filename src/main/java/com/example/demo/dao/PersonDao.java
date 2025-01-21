package com.example.demo.dao;

import com.example.demo.model.Person;
import io.micrometer.common.lang.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int inserPerson(UUID id, Person person);

    default int addPerson(@NonNull Person person) {
        UUID id = UUID.randomUUID();
        return inserPerson(id, person);
    }
    List<Person> sellectAllPerson();

    Optional<Person> sellectPersonById(UUID id);
    int deletePersonById(UUID id);
    int updatexPersonById(UUID id, Person person);

    int updatePersonById(UUID id, Person person);
}


