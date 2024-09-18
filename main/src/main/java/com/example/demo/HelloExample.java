package com.example.demo;

/**
 * @author hantsy
 */
public class HelloExample {

    // traditional main method.
    // public static final void main(String args[]) throws Exception {
    //     var greeter = new Greeter();
    //     System.out.println(greeter.greet("Hantsy"));
    // }


    // Java 21 preview. 
    //  void main() throws Exception {
    //     var greeter = new Greeter();
    //     System.out.println(greeter.greet("Hantsy"));
    // }
}


class Greeter {
    public String greet(String name) {
        if( name != null && !name.isEmpty()) return "Hello, " + name;
        return "Hello, World";
    }
}