package com.example.demo;

public class SealedSample {
    public static void main(String[] args) {
        var circle = new Shape.Circle(new Point(2, 3), 3);
        //calArea(circle);
        calAreaInstanceOf(circle);
    }


/*    public static void calArea(Shape shape) {
        float area = switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Rectangle  r -> Math.abs((r.upperRight().y() - r.lowerLeft().y())
                        * (r.upperRight().x() - r.lowerLeft().x()));
                // no default needed!
        };
        System.out.println("area:" + area);
    }
    */


    public static void calAreaInstanceOf(Shape shape) {
        double area = 0.0f;
        if (shape instanceof Shape.Circle c) {
            area = Math.PI * c.radius() * c.radius();
        } else if (shape instanceof Shape.Rectangle r) {
            area = Math.abs((r.upperRight().y() - r.lowerLeft().y())
                    * (r.upperRight().x() - r.lowerLeft().x()));
        }

        System.out.println("area:" + area);
    }
}

sealed interface Shape permits Shape.Circle, Shape.Rectangle {

    record Circle(Point center, int radius) implements Shape {
    }

    record Rectangle(Point lowerLeft, Point upperRight) implements Shape {
    }
}

record Point(float x, float y) {
}
