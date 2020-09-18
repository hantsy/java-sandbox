package com.example.demo;

import java.time.LocalDateTime;

public class CelestialExample {
    public static void main(String[] args) {
/*        switch (celestial) {
            case Planet(String name, double mass, double radius): ...
            case Star(String name, double mass, double temp): ...
            case Comet(String name, double period, LocalDateTime lastSeen): ...
        }*/
    }
}

sealed interface Celestial {
    record Planet(String name, double mass, double radius)
            implements Celestial {
    }

    record Star(String name, double mass, double temperature)
            implements Celestial {
    }

    record Comet(String name, double period, LocalDateTime lastSeen)
            implements Celestial {
    }
}