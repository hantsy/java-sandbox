# Sealed classes

Java 15 added a preview feature - sealed classes which existed in Scala for a long time.

An example of `sealed` class.

```java
sealed interface Shape permits Shape.Circle, Shape.Rectangle {

    record Circle(Point center, int radius) implements Shape {
    }

    record Rectangle(Point lowerLeft, Point upperRight) implements Shape {
    }
}
```

The `sealed`  keyword can be applied on classes or an interface. Like `Enum` and `Record`, the subclasses are implicitly **final**.

You can explicitly add **final**, **sealed** or **non-sealed** to the subclasses.

Currently you can use `instanceof` pattern matching in **if**/**else** conditional statement.

```java
double area = 0.0f;
if (shape instanceof Shape.Circle c) {
    area = Math.PI * c.radius() * c.radius();
} else if (shape instanceof Shape.Rectangle r) {
    area = Math.abs((r.upperRight().y() - r.lowerLeft().y())
                    * (r.upperRight().x() - r.lowerLeft().x()));
}

System.out.println("area:" + area);
```

Ideally sealed classes should work seamlessly in the multicases of  `switch` statement, like Scala or Kotlin, but currently it is NOT included yet.