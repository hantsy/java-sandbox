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

Obviously, the text block form improves readability.  It is very helpful to build some long character sequence but keep its structure, such as HTML,  Hibernate HQL  or JPQL, scripting codes, etc. 

The following is a  HTML string written in a text block form.

```java
 String tbhtml = """
     		<html>
                <body>
                	<p>Hello, Java 13</p>
                </body>
            </html>""";
```

Another example, In Java 13,  a  JPQL string could be written like this:

```java
String query = """
        select firstName, lastName, email
        	from User
        	where id= ?
        """;
```

Embedding Javascript snippets and evaluating it in Java `ScirptEngine` is a piece of cake:

```java
ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
Object result = engine.eval("""
                            function hello(name) {
                                return "Hello, " + name;
                            }
                            hello("Java 13");""");
System.out.println("function add result is:" + result);
```



The following is how text block described in [JEP355](https://openjdk.java.net/jeps/355).

> A text block consists of zero or more content characters, enclosed by opening and closing delimiters.

> The *opening delimiter* is a sequence of three double quote characters (`"""`) **followed by zero or more white spaces followed by a line terminator**. The *content* begins at the first character after the line terminator of the opening delimiter.

The following are ill-formed  text block.

```java
String a = """""";   // no line terminator after opening delimiter
String b = """ """;  // no line terminator after opening delimiter
```

> The *closing delimiter* is a sequence of three double quote  characters. The content ends at the last character before the first  double quote of the closing delimiter.

The following text block  is incorrect.

```java
String c = """
           ";        // no closing delimiter (text block continues to EOF)
```

> The content may include double quote characters directly, unlike the characters in a string literal. The use of `\"` in a text block is permitted, but not necessary or recommended. Fat delimiters (`"""`) were chosen so that `"` characters could appear unescaped, and also to visually distinguish a text block from a string literal.

But if a  three quote marks (""") occurs in a text block, you should prepend a "\" to escape it,  for example.

```java
String escapes = """
            Hello, \""" Java 13
            """;
System.out.println("Escaped string:\n" + escapes);
```

When run this  code snippets, it should print `Hello, """ Java 13` in the output console .

A text block is processed by Java compiler at compile time, there are three steps, details are described in  [JEP355](https://openjdk.java.net/jeps/355).

> A text block is a [constant expression](https://docs.oracle.com/javase/specs/jls/se12/html/jls-15.html#jls-15.28) of type `String`,  just like a string literal. However, unlike a string literal, the  content of a text block is processed by the Java compiler in three  distinct steps:
>
> 1. Line terminators in the content are translated to LF (`\u000A`). The purpose of this translation is to follow the principle of least surprise when moving Java source code across platforms.
>
> 2. Incidental white space surrounding the content, introduced to match the indentation of Java source code, is removed.
>
> 3. Escape sequences in the content are interpreted. Performing  interpretation as the final step means developers can write escape  sequences such as `\n` without them being modified or deleted by earlier steps.
>

Let's have a look at how *incidental white space* is removed at compile time.

```java
String hello = """
            Hello,
            Java 13
            """;
```

To make it clear, let's replace an incidental white space with a dot.

```java
String hello = """
............Hello,
............Java 13
............""";
```

After is processed by Java compiler, the content of the string should be truncated as:

```java
Hello,
Java 13
<new line delimiter> 
```

Another example ,  we change the closing delimiter position,

```java
String hello2 = """
            Hello,
            Java 13
        """;
```

Similarly, replace the incidental white spaces with dots.

```java
String hello2 = """
........    Hello,
........    Java 13
........""";
```

Finally the text block should be processed like:

```java
    Hello,
    Java 13
<new line delimiter> 
```

Let's  the third example ,  the closing delimiter is not placed in a new line. 

```java
String hello3 = """
            Hello,
            Java 13""";
```

Similarly, using dots to visualize the spaces .

```java
String hello3 = """
............Hello,
............Java 13""";

```

And the content of hello3 is :

```java
Hello,
Java 13
```

The `hello`, `hello2` and `hello3` are similar, but they are different strings.