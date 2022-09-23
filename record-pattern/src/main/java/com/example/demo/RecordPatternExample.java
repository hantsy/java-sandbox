/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

/**
 *
 * @author hantsy
 */
public class RecordPatternExample {

    public static final void main(String args[]) {
        printPerson(new Person("Hantsy", "Bai"));
    }

    static void printPerson(Object object) {
        if (object instanceof Person(String firstName, String lastName)) {
            System.out.println(firstName + " " + lastName);
            return;
        }
    }

}

record Person(String firstName, String lastName) {}
