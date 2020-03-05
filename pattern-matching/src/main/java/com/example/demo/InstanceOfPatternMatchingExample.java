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
public class InstanceOfPatternMatchingExample {
    public static final void main(String args[]) {
        instanceOfBefore14();
        instanceOf14();     
    }
    
    static void instanceOfBefore14() {
        System.out.println("Before Java 14:");
        Animal cat = new Cat();
        if(cat instanceof Cat){
            Cat catObj= (Cat) cat;
            System.out.println("it is a cat:" +catObj);
        }
    }
    
     static void instanceOf14() {
        System.out.println("In Java 14 or later:");
        Animal cat = new Cat();
        if(cat instanceof Cat catObj){
            System.out.println("it is a cat:" +catObj);
        }
    }
    
}

class Animal{
}
class Cat extends Animal{

    @Override
    public String toString() {
        return "Cat{" + '}';
    }

}
class Dog extends Animal{

    @Override
    public String toString() {
        return "Dog{" + '}';
    }
}