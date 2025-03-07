package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

public class Person {

    private  final UUID id;
       @NonNull
    private final String name;


    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }


}

