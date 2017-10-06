/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hantsylab.java9hacks;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 *
 * @author hantsy
 */
public class OptionalSample {

    public static final void main(String[] args) {
        String optional = Optional.<String>empty().or(() -> Optional.of("alternatives")).get();
        System.out.println("Optional is empty or alternatives:" + optional);

        String optionalDefault = Optional.<String>of("default").or(() -> Optional.of("alternatives")).get();
        System.out.println("Optional default or alternatives:" + optionalDefault);

        Optional.<String>empty().ifPresentOrElse((o) -> System.out.println("call comsumer:" + o), () -> System.out.println("call runnable"));

        Optional.<String>of("default").ifPresentOrElse((o) -> System.out.println("call comsumer:" + o), () -> System.out.println("call runnable"));
        
        
        Optional.<String>empty().stream().forEach(System.out::println);
        Optional.<String>of("default").stream().flatMapToInt(o -> IntStream.of(o.length())).forEach(System.out::println);

    }
}
