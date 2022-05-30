package com.basic.spring.application.basic.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Car {

    private final UUID id;
    @NotBlank
    private final String name;

    public Car(@JsonProperty("id") UUID id,@JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
    public UUID getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}
