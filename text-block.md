# Text Block Example

*Text block* or so called *multi lines String* got support in Java 13 as a **preview** feature. 

> You should append `--enable-preview` parameter  to java compiler or Jshell to  activate this feature, see  [Pattern Matching](./pattern-matching)

Before Java 13 you could have to write a multi-lines String like this.

```java
String hello="Hello,\nJava 13\n";
```

 or concatenate multi character sequence into a string with one or more **+**  operators. 

```java
String hello="Hello,\n"
    +"Java 13\n";
```

In Java 13,  this can be replaced  by text block.

```java
String hello="""
    Hello,
    Java 13
    """;    
```

Obviously, the text body form improves readability. 

The following is how text block described in [JEP355](https://openjdk.java.net/jeps/355).

> A text block consists of zero or more content characters, enclosed by opening and closing delimiters.
>
> The *opening delimiter* is a sequence of three double quote characters (`"""`) **followed by zero or more white spaces followed by a line terminator**. The *content* begins at the first character after the line terminator of the opening delimiter.
>
> The *closing delimiter* is a sequence of three double quote  characters. The content ends at the last character before the first  double quote of the closing delimiter.

The following are incorrect text block.

```java
String a = """""";   // no line terminator after opening delimiter
String b = """ """;  // no line terminator after opening delimiter
```

