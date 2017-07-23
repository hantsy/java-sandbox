# java9-sandbox

The long-waiting Java 9 is close to be done, a lots of new features were added in this release, including the controversial Java Platform Module System, the new Flow API(as Java built-in Reactive Stream implementation), and numberous language improvements.

## Prerequisite

1. Install JDK 9 from http://jdk.java.net/9
2. NetBeans IDE 9 nightly or Eclipse Oxygen(4.7) with Java 9 support(install Java 9 beta support in Eclipse Marketplace)

## Immutable Collections

Generally creating an immutable collection could like:

```java
Set<String> set = new HashSet<>();
set.add("One");
set.add("Two");
set.add("Three");
set.add("Four");
Collections.unmodifiableSet(set);
```

If using Java 5, this can be simplified as:

```
Set<String> units = new HashSet<>(Arrays.asList(“One”, “Two”, “Three”, “Four”));
units = Collections.unmodifiableSet(units);
```

Or using Java 8 Stream API.

```
Stream.of("One", "Two", "Three", "Four")
	.collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
```

Google Guava provides simple immutable collection utilities.

```
ImmutableSet.of("One", "Two", "Three", "Four");
```

Or create an immutable set from an existing set.

```
ImmutableSet.copyOf(set);
```

In Java 9, a static factory method `of` is introduced in `Set`, `List`, `Map` interface to create an instance quickly.

```java

Set<String> set = Set.of("One", "Two", "Three", "Four");

System.out.println("set::" + set);

List<String> list = List.of("One", "Two", "Three", "Four");

System.out.println("list::" + list);

Map<Integer, String> map = Map.of(1, "One", 2, "Two", 3, "Three", 4, "Four");

System.out.println("map::" + map);
```

In the background, they invoke a `ImmutableCollections` utility class. 

The collections instantiated by these factory methods have some specific characteristics:

* **Immutable**: Elements cannot be added or removed. Calling any mutator method will always cause `UnsupportedOperationException` to be thrown

* **No null Element Allowed**: Attempts to create them with null elements result in `NullPointerException`. In the case of List and Set, no elements can be null. In the case of a Map, neither keys nor values can be null.

* **Value-Based Instances**: If we create Lists with the same values, they may or may not refer to the same object on the heap.

* **Serialization**:  They are serializable if all elements are serializable.

* **Iteration Order**: The iteration order of elements is unspecified and is subject to change.

## JShell

Unlike Ruby, Python, and other JVM language, such as Groovy, Java itself lacks an interactive shell for a long time. Some 3rd party projects tried to fill the blank, such as Apache Bean Shell. Java 9 brings a built-in shell.

Open your terminal(cmd under Windows or Gnome Terminal under Linux/Gnome) and type `jshell`(make sure it is in your PATH environment variable or use the full path) to start up JShell console.

```
#jshell
|  Welcome to JShell -- Version 9
|  For an introduction type: /help intro

jshell>
```

It shows the welcome info.

Type `/help intro` to get a simple introduction to JShell.

```
jshell> /help intro
|
|  intro
|
|  The jshell tool allows you to execute Java code, getting immediate results.
|  You can enter a Java definition (variable, method, class, etc), like:  int x = 8
|  or a Java expression, like:  x + x
|  or a Java statement or import.
|  These little chunks of Java code are called 'snippets'.
|
|  There are also jshell commands that allow you to understand and
|  control what you are doing, like:  /list
|
|  For a list of commands: /help
```

Type `/help` to get the all help info of `jshell`.

Try add some code pieces to taste Java language features.

```
jshell> int i=1+1;
i ==> 2

jshell>

jshell> System.out.println(i);
2

```

Test the new ImmutableCollections features we have dicussed in the last section.

```
jshell> import java.util.*;

jshell> Set.of("One", "Two", "Three", "Four");
$4 ==> [Four, One, Three, Two]

jshell> System.out.println("set ::" + $4);
set ::[Four, One, Three, Two]

jshell> $4.add("Five");
|  java.lang.UnsupportedOperationException thrown:
|        at ImmutableCollections.uoe (ImmutableCollections.java:70)
|        at ImmutableCollections$AbstractImmutableSet.add (ImmutableCollections.java:280)
|        at (#6:1)

jshell> $4.remove("One");
|  java.lang.UnsupportedOperationException thrown:
|        at ImmutableCollections.uoe (ImmutableCollections.java:70)
|        at ImmutableCollections$AbstractImmutableSet.remove (ImmutableCollections.java:283)
|        at (#7:1)
jshell> Set<String> set= $4;
set ==> [Four, One, Three, Two]

jshell> set.add(null);
|  java.lang.UnsupportedOperationException thrown:
|        at ImmutableCollections.uoe (ImmutableCollections.java:70)
|        at ImmutableCollections$AbstractImmutableSet.add (ImmutableCollections.java:280)
|        at (#10:1)
```

As you see, the created collections do not allow to add or remove items.

```
jshell> /vars
|    int i = 2
|    Set<String> $4 = [Four, One, Three, Two]
|    boolean $6 = false
|    boolean $7 = false
|    boolean $8 = false
|    Set<String> set = [Four, One, Three, Two]
|    boolean $10 = false
```

Every step JShell creates a variable to mark it, if you do not define an explicit variable, it will assign one for you. You can refer any defined before in your current code snippets.

```
jshell> /exit
|  Goodbye
```

Type `/exit` to quit JShell console.

## References

* [Immutable Collections in Java 9 ](https://dzone.com/articles/immutable-collections-in-java-9)
* [Immutable Collections Explained](https://github.com/google/guava/wiki/ImmutableCollectionsExplained)
* [What is new in JDK 9](https://www.quora.com/What-is-new-in-JDK-9)
* [Devoxx 55 New Features in JDK 9 by Simon Ritter](https://goo.gl/d2F7rH)