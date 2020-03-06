# Small improvements in Text Block support in Java 14

In Java 14,  there are two small improvements added in *Text Block*.

Two new escape sequences were added in Java 14. First, you can use the new `\s` escape sequence to mean a single space. 

For example, 

```java
String whitespaceEscapes = """
                                \s Hello,\s Java 14!\s
                                   """;

        System.out.println("Escaped whitespaces by a \\s char in Java 14:\n" + whitespaceEscapes.replaceAll(" ", "."));
```

It will print the result in the console.

```bash
Escaped whitespaces by a \s char in Java 14:
..Hello,..Java.14!.
```

It inserted white spaces at the beginning and ending of this line which changed the incident characters  processing.

Second, you can use a backslash, `\`, as a way to suppress the insertion of a new line character at the end  of a line. This is helpful when you have a very long line that you want  to split up for ease of readability inside a text block.

The the processing is similar with the bash multi lines command.  To input a long command like this in the Linux terminal, you could break the a long literal in multi lines by appending  a  `\`  at the ending of  every lines. It will result in a long single-line based string finally.

```java
String noNewlines = """
    mvn archetype:generate -DgroupId=com.example
        -DartifactId=demo
        -DarchetypeArtifactId=maven-archetype-webapp
        -DinteractiveMode=false
        """;
        System.out.println("No line delimiters at the end of every lines:\n" + noNewlines.replaceAll(" ", "."));

String newlines = """
    mvn archetype:generate -DgroupId=com.example                 \
        -DartifactId=demo                            \
        -DarchetypeArtifactId=maven-archetype-webapp \
        -DinteractiveMode=false                      \
        """;
        System.out.println("New line delimiters added at the end of every lines:\n" + newlines.replaceAll(" ", "."));

```

It will print the following result. Compared the result of the two samples, the second result is a long **single-line** string without new line breaks.

```bash
mvn.archetype:generate.-DgroupId=com.example
..............	-DartifactId=demo
...............	-DarchetypeArtifactId=maven-archetype-webapp
..............	-DinteractiveMode=false

New line delimiters added at the end of every lines:
mvn.archetype:generate.-DgroupId=com.example.........................	-DartifactId=demo....................................	-DarchetypeArtifactId=maven-archetype-webapp.........	-DinteractiveMode=false......................

```



