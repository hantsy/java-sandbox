package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyVisibilityStrategy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JsonbExample {
    public static void main(String[] args) {
        PropertyVisibilityStrategy propertyVisibilityStrategy = new PropertyVisibilityStrategy() {
            @Override
            public boolean isVisible(Field field) {
                return true;
            }

            @Override
            public boolean isVisible(Method method) {
                return false;
            }
        };
        var jsonb = JsonbBuilder.create(new JsonbConfig().withFormatting(true)
                .withNullValues(false)
                .withPropertyVisibilityStrategy(propertyVisibilityStrategy)
                .withEncoding("UTF-8")
        );
        var person = new RecordPerson("Java", 25);


        var json = jsonb.toJson(person);
        System.out.println("person json: " + json);

        var decodedPerson = jsonb.fromJson(json, RecordPerson.class);
        System.out.println("person object: " + decodedPerson);

    }
}
