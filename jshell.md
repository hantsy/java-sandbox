# JShell

Unlike Ruby, Python, and other JVM language, such as Groovy, Scala, Java itself lacks an interactive shell for a long time. Some 3rd party projects tried to fill the blank, such as Apache Bean Shell. Java 9 brings a built-in shell.

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

Test the new Immutable Collections features we have discussed in the last section.

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