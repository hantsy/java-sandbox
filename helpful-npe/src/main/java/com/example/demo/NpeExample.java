package com.example.demo;

import java.util.Objects;
import javax.script.ScriptException;

public class NpeExample {

    public static final void main(String[] args) throws ScriptException {

        Person person = new Person();
        
        System.out.println("Get the city of the address of a Person:\n"+ person.getAddress().getCity().getName());

    }
}

class Person {

    private String name;
    private int age;

    private Address address;

    public Person() {
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}

class Address {

    private final City city;

    public Address(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

}

class City {

    private final String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
