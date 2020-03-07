/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.Map;
import java.util.stream.Stream;

/**
 *
 * @author hantsy
 */
public class StreamSample {

    public static final void main(String[] args) {
        
        //Java 9
        Stream.of("hello", "java 9", "stream")
                .takeWhile(s -> s.contains("h"))
                .forEach(System.out::println);

        Stream.of("hello", "java 9", "stream")
                .dropWhile(s -> s.contains("h"))
                .forEach(System.out::println);

        Stream.iterate(0, i -> i < 10, i -> i = i + 1)
                .forEach(System.out::println);

        Map<Integer, String> seeds = Map.of(1, "Hello", 2, "Java 9", 3, "Stream");
        Stream.of(1, 3, 4)
                .flatMap( i -> Stream.ofNullable(seeds.get(i)))
                .forEach(System.out::println);

    }
}
