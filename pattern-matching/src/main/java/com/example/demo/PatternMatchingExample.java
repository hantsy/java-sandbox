package com.example.demo;

import java.time.LocalDate;

public class PatternMatchingExample {

    static enum Color {
        R, G, B
    }

    public static void printColor(Color c) {
        String out;
        switch (c) {
            case R:
                out = "red";
                break;
            case G:
                out = "green";
                break;
            case B:
                out = "blue";
                break;
            default:
                out = "unknown";
        }
        System.out.println("the color is " + out);
    }

    public static void printColorYield(Color c) {
        String out = switch (c) {
            case R:
                yield "red";
            case G:
                yield "green";
            case B:
                yield "blue";
            default:
                yield "unknown";
        };
        System.out.println("the color is " + out);
    }

    public static void printColorPatternMatching(Color c) {
        String out = switch (c) {
            case R -> "red";
            case G -> "green";
            case B -> "blue";
            default -> "unknown";
        };
        System.out.println("the color is " + out);
    }

    public static void printDayOfWeek() {
        String out = switch (LocalDate.now().getDayOfWeek()) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "working day";
            case SUNDAY, SATURDAY -> "weekend";
            default -> throw new IllegalStateException("unknown");
        };

        System.out.println("today is " + out);
    }


/*

    class Animal{}
    class Cat extends Animal{}
    class Dog extends Animal{}

    public static void printAnimal() {
       System.out.println("This animal is:");
        Animal cat = new Cat();
        switch (cat) {
            case Cat -> System.out.println("cat");
            case Dog -> System.out.println("dog");
            default -> throw new IllegalStateException("unknown");
        };
    }

 */

    public static final void main(String[] args) {

        System.out.println("print color using classic switch:");
        printColor(Color.R);

        System.out.println("print color using yield in switch:");
        printColorYield(Color.B);

        System.out.println("using the new pattern matching:");
        printColorPatternMatching(Color.B);

        System.out.println("grouped label in pattern matching: ");
        printDayOfWeek();
    }
}
