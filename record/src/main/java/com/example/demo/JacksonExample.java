package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExample {
    public static void main(String[] args) {
        var person = new RecordPerson("Java", 25);
        ObjectMapper mapper = new ObjectMapper();
        try {
            var json = mapper.writeValueAsString(person);
            System.out.println("person json: " + json);
            
            var decodedPerson = mapper.readValue(json, RecordPerson.class);
            System.out.println("person object: " + decodedPerson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
