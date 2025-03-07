package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements  PersonDao {

    private  static List<Person> DB= new ArrayList<>();

    @Override
    public int inserPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> sellectAllPerson() {
        return DB;
    }

    @Override
    public Optional<Person> sellectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = sellectPersonById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }

        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatexPersonById(UUID id, Person person) {
        return 0;
    }


    @Override
    public int updatePersonById(UUID id, Person update) {
        return sellectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }








}


