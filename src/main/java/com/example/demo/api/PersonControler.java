package com.example.demo.api;


import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import io.micrometer.common.lang.NonNullFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/sms/person")
@RestController
public class PersonControler {
    private final PersonService personService;
    @Autowired
    public PersonControler(PersonService personService) {
        this.personService = personService;

    }
    @PostMapping
    public void addPerson  (@Validated   @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person>  getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable("id")  UUID id) {
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public  void deletePersonById (@PathVariable ("id") UUID id){
           personService.deletePerson(id);
    }

    @PutMapping(path = "/{id}")
    public void updatePerson(@PathVariable ("id") UUID id ,@Validated @NonNull @RequestBody Person person) {
        personService.updatePerson(id,person);
    }
}
