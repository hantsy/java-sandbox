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
        
        printShapeArea(new Circle(1.2));
        printShapeArea(new Square(1.2));
        printShapeArea(new Rectangle(1.0, 2.0));
    }

    static void printPerson(Object object) {
        if (object instanceof Person(String firstName, String lastName)) {
            System.out.println(firstName + " " + lastName);
            return;
        }
    }
    
    static void printShapeArea(Shape s) {
        var shape =  switch(s) {
            case Circle(Double r) -> "Circle with r:" + r;
            case Square(Double x) -> "Square with x:" + x;
            case Rectangle(Double x, Double y) -> "Rectangle with x: "+x+ " and y:"+y;
            default -> "Unkown";
        };
        System.out.println(shape + ", area:"+ s.area());
    }

}

record Person(String firstName, String lastName) {}

sealed interface Shape permits Circle, Square, Rectangle{
    Double area();
}

record Circle(Double r) implements Shape{

    @Override
    public Double area() {
        return r * r * 3.14;
    }
}

record Square(Double x) implements Shape{

    @Override
    public Double area() {
        return x * x;
    }
}

record Rectangle(Double x, Double y) implements Shape{

    @Override
    public Double area() {
        return x * y;
    }
}
