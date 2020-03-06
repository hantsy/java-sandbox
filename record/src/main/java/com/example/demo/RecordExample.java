package com.example.demo;

import java.util.Objects;
import javax.script.ScriptException;

public class RecordExample {

    public static final void main(String[] args) throws ScriptException {

        Person person = new Person("Person before Java 14", 15);

        System.out.println("Person before Java 14:\n" + person);

        RecordPerson person14 = new RecordPerson("Person in Java 14", 15);

        System.out.println("Person in Java 14:\n" + person14);
        
        System.out.println("Person'name in Java 14:\n" + person14.name());
        System.out.println("Person'age in Java 14:\n" + person14.age());
        
        RecordPerson person14Copy = new RecordPerson(person14.name(), person14.age());
        System.out.println("Person.equals in Java 14:\n" + person14Copy.equals(person14));

        RecordPerson anotherPersone14 = new RecordPerson("Another Person in Java 14");

        System.out.println("Another Person in Java 14:\n" + anotherPersone14);

        RecordPerson invalid = new RecordPerson("Invalid age assigned to a Person", 0);// will throw an IllegalArgumentException

        System.out.println("Another Person in Java 14:\n" + anotherPersone14);

    }
}
