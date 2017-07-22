/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hantsylab.java9hacks;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hantsy
 */
public class ImmutableCollectionsSample {

    public static final void main(String[] args) {
        
//java 5        
//        Set<String> units = new HashSet<>(Arrays.asList(“One”, “Two”, “Three”, “Four”));
//        units = Collections.unmodifiableSet(units);

//java 8
//        Stream.of("One", "Two", "Three", "Four")
//                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));

        Set<String> set = Set.of("One", "Two", "Three", "Four");

        System.out.println("set::" + set);

        List<String> list = List.of("One", "Two", "Three", "Four");

        System.out.println("list::" + list);

        Map<Integer, String> map = Map.of(1, "One", 2, "Two", 3, "Three", 4, "Four");

        System.out.println("map::" + map);
//Immutable: Elements cannot be added or removed. Calling any mutator method will always cause UnsupportedOperationException to be thrown
//
//No null Element Allowed: Attempts to create them with null elements result in NullPointerException. In the case of List and Set, no elements can be null. In the case of a Map, neither keys nor values can be null.
//
//Value-Based Instances: If we create Lists with the same values, they may or may not refer to the same object on the heap.
//
//Serialization:  They are serializable if all elements are serializable.
//
//Iteration Order: The iteration order of elements is unspecified and is subject to change.
    }

}
