/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;
import java.util.stream.Stream;

/**
 *
 * @author hantsy
 */
public class ImmutableCollectionsSample {

    public static final void main(String[] args) {

        Set<String> set0 = new HashSet<>();
        set0.add("One");
        set0.add("Two");
        set0.add("Three");
        set0.add("Four");
        Set<String> unmodifiableSet = Collections.unmodifiableSet(set0);
        System.out.println("set0:" + unmodifiableSet);

        //java 5        
        Set<String> units = new HashSet<>(Arrays.asList("One", "Two", "Three", "Four"));
        units = Collections.unmodifiableSet(units);

        //java 8
        Stream.of("One", "Two", "Three", "Four")
                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));

        // java 9
        Set<String> set = Set.of("One", "Two", "Three", "Four");

        System.out.println("set::" + set);

        List<String> list = List.of("One", "Two", "Three", "Four");

        System.out.println("list::" + list);

        Map<Integer, String> map = Map.of(1, "One", 2, "Two", 3, "Three", 4, "Four");

        System.out.println("map::" + map);

        Set.of("one", null);//throw java.lang.NullPointerException
        List.of("one", "two", null);//throw java.lang.NullPointerException
        Map.of(1, "One", 2, "Two", null, "Three");//throw java.lang.NullPointerException
        Map.of(1, "One", 2, "Two", 3, null);//throw java.lang.NullPointerException

    }

}
