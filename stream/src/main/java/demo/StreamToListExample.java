package demo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamToListExample {
    public static void main(String[] args) {
        IntStream.range(1, 100)
                .mapToObj(i ->  "Hello, #"+ i)
                
                // since Java 16, use `toList` to replace `.collect(Collectors.toList())`
                .toList()
                .forEach(System.out::println);
    }
}
