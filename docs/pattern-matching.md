# Pattern Matching 

Java 13 enhanced the existing `switch` make it looks smoothing and a little like the `match` of Scala and `when` of Kotlin.

Let's have a look at a simple `switch` example that works in Java 8. 

```java
static enum Color {
    R, G, B
}

public static void printColor(Color c) {
    String out;
    switch (c) {
        case R:
            out = "red";
            break;
        case G:
            out = "green";
            break;
        case B:
            out = "blue";
            break;
        default:
            out = "unknown";
    }
    System.out.println("the color is " + out);
}
```

The `switch`  is  a **statement**, and each `case` uses a `break` to quit switch. If you forget to add a `break`, the flow will turn to the next `case`, sometime it will cause issues and it is very difficult to determine the bugs.

In Java 13, you can use the *generator*  and *yield* like clauses in `switch` codes.

```java
public static void printColorYield(Color c) {
    String out = switch (c) {
        case R:
            yield "red";
        case G:
            yield "green";
        case B:
            yield "blue";
        default:
            yield "unknown";
    };
    System.out.println("the color is " + out);
}
```

In the above codes, `switch` is an **expression**, the return value is assigned to a variable `out`, and every `case`, use a `yield`  clause to return the value directly thus avoid some issues  caused by forgetting `break`. 

More simply,  the `case` accept an lambda expression now. 

```java
public static void printColorPatternMatching(Color c) {
    String out = switch (c) {
        case R -> "red";
        case G -> "green";
        case B -> "blue";
        default -> "unknown";
    };
    System.out.println("the color is " + out);
}
```

And the case conditions can be grouped into  one case if the handling clause has no difference.

```java
public static void printDayOfWeek() {
    String out = switch (LocalDate.now().getDayOfWeek()) {
        case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "working day";
        case SUNDAY, SATURDAY -> "weekend";
        default -> throw new IllegalStateException("unknown");
    };

    System.out.println("today is " + out);
}
```

Unluckily , in Java 13, `switch` still can not accept `case class` like Scala,  the following example will fail.

```java
class Animal{}
class Cat extends Animal{}
class Dog extends Animal{}

public static void printAnimal() {
    System.out.println("This animal is:");
    Animal cat = new Cat();
    switch (cat) {
        case Cat -> System.out.println("cat");
        case Dog -> System.out.println("dog");
        default -> throw new IllegalStateException("unknown");
    };
}
```

In java 13, the Pattern Matching is a **preview** feature, when you are using Apache Maven, add `--enable-preview`  *compilerArg* parameter in the *configuration* of maven compiler plugin to build the project. 

 ```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <release>13</release>
        <compilerArgs>
            <compilerArg>--enable-preview</compilerArg>
        </compilerArgs>
    </configuration>
</plugin>
 ```

If you want to experience Pattern Matching in jshell, add `--enable-preview`  to jshell command to start up it.

```bash
jshell --enable-preview
```

