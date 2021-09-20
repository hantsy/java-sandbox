# Switch pattern matching example

Similar to the Scala *case pattern matching* and Kotlin *when*, Java 17 finally allow Java type as `case` condition in the switch statement or expression. 

> NOTE: It is a **preview** feature of Java 17.

```java

//since java 17 and enable preview.
static class Animal {
}

static class Cat extends Animal {
}

static class Dog extends Animal {
}

@SuppressWarnings("preview")
public static void printAnimal(Animal a) {
     System.out.println("This animal is:");
      switch (a) {
          case Cat c-> System.out.println("cat");
          case Dog d-> System.out.println("dog");
          default -> throw new IllegalStateException("unknown");
      };
  }
```

The `sealed` classes also can be applied in the `switch` clause.

```java
public class SealedSample {
    public static void main(String[] args) {
        var circle = new Circle(new Point(2, 3), 3);
        calArea(circle);
        calAreaInstanceOf(circle);
    }

    public static void calArea(Shape shape) {
        var area = switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Rectangle r -> Math.abs((r.upperRight().y() - r.lowerLeft().y())
                    * (r.upperRight().x() - r.lowerLeft().x()));
            // no default needed!
        };
        System.out.println("area:" + area);
    }

    public static void calAreaInstanceOf(Shape shape) {
        double area = 0.0;
        if (shape instanceof Circle c) {
            area = Math.PI * c.radius() * c.radius();
        } else if (shape instanceof Rectangle r) {
            area = Math.abs((r.upperRight().y() - r.lowerLeft().y())
                    * (r.upperRight().x() - r.lowerLeft().x()));
        }

        System.out.println("area:" + area);
    }
}

sealed interface Shape permits Circle, Rectangle {
}

record Rectangle(Point lowerLeft, Point upperRight) implements Shape {
}

record Circle(Point center, int radius) implements Shape {
}

record Point(float x, float y) {
}
```
