package com.example.demo;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TextBlockExample {

    public static final void main(String[] args) throws ScriptException {
        printHtml();

        printJPQL();

        printScripts();

        printEscapes();
        
        printNewLineDelimiter();

        printStripIndents();

        printFormattedMethod();

        printTranslateEscapes();

        printThreeMethods();
    }

    private static void printThreeMethods() {
        String s = "  there are 2 spaces in the front of line one\n    the second line begins with 4 spaces and ends with an escaped new line\\n      the third line has 6 spaces at the beginning";
        System.out.println("original string :\n" + s);
        System.out.println("original string after stripIntent :\n" + s.stripIndent());
        System.out.println("original string after translateEscapes :\n" + s.translateEscapes());
        System.out.println("original string after stripIntent and translateEscapes :\n" + s.stripIndent().translateEscapes());
        System.out.println("original string after translateEscapes and stripIntent:\n" + s.translateEscapes().stripIndent());
    }

    private static void printTranslateEscapes() {
        String hasNewLine = "select * from User \\nwhere id = 1";
        System.out.println("string before translateEscapes():\n" + hasNewLine);
        String translated = hasNewLine.translateEscapes();
        System.out.println("string after translateEscapes():\n" + translated);
    }

    private static void printFormattedMethod() {
        String product = """
                                 {
                                    "name":"%s",
                                    "price":%.2f
                                 }
                                 """.formatted("Java 8 in action", 39.3444);

        System.out.println("product formatted: \n " + product);
    }

    private static void printStripIndents() {
        String hello = """
            Hello,
            Java 13
            """;

        String hello2 = """
            Hello,
            Java 13
        """;

        System.out.println("Hello1:\n" + hello);
        System.out.println("Hello2:\n" + hello2);

        System.out.println("hello is equals hello2:" + hello.equals(hello2));
        System.out.println("hello after stripIntent():\n" + hello.stripIndent());
        System.out.println("hello2 after stripIntent():\n" + hello2.stripIndent());
        System.out.println("hello is equals hello2 after stripIndent():" + hello.stripIndent().equals(hello2.stripIndent()));

        String hello3 = """
                                Hello,
                                Java 13""";

        System.out.println("hello3:\n" + hello3);

        System.out.println("hello is equals hello3:" + hello.equals(hello3));
        System.out.println("hello3 after stripIntent():\n" + hello3.stripIndent());
        System.out.println("hello.replace(\" \",\".\").replace(\"\\n\",\"@\"):\n" + hello.replace(" ", ".").replace("\n", "@"));
        System.out.println("hello3.replace(\" \",\".\").replace(\"\\n\",\"@\"):\n" + hello3.replace(" ", ".").replace("\n", "@"));
        System.out.println("hello is equals hello3 after stripIndent():" + hello.stripIndent().equals(hello3.stripIndent()));

        System.out.println("hello is equals hello3 after trim():" + hello.trim().equals(hello3.trim()));
    }

    // added in java 14
    private static void printNewLineDelimiter() {
        String noNewlines = """
                Hello,           
                        Java 14! 
                        """;
        System.out.println("No line delimiters at the end of every lines:\n" + noNewlines.replaceAll(" ", ".").replaceAll("\\n", "@"));
        
        String newlines = """
                Hello,            \
                        Java 14!  \
                        """;
        System.out.println("New line delimiters added at the end of every lines:\n" + newlines.replaceAll(" ", ".").replaceAll("\\n", "@"));

    }

    private static void printEscapes() {
        String escapesLine = """
                                     Hello, \n Java 13
                                     """;
        System.out.println("Escaped string line delimiter:\n" + escapesLine);

        String escapes = """
                                 Hello, \""" Java 13
                                 """;
        System.out.println("Escaped string:\n" + escapes);

        String whitespaceEscapes = """
                                    Hello,\s Java 14
                                   """;

        System.out.println("Escaped whitespaces by a \\s char in Java 14:\n" + whitespaceEscapes);
    }

    private static void printScripts() throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        Object result = engine.eval("""
                                            function hello(name) {
                                            return "Hello, " + name;
                                            }
                                            hello("Java 13");""");
        System.out.println("function add result is:" + result);
    }

    private static void printJPQL() {
        // the whitespace owed to the code formatting is removed. It is marked with the position of the concluding three quotation marks
        String query = """
                                   select firstName,
                                   lastName,
                                   email
                                   from User
                                   where id= ?
                               """;

        System.out.println("SQL or JPL like query string :\n" + query);
    }

    private static void printHtml() {
        // Without Text Blocks
        String html = "<html>\n"
                + "   <body>\n"
                + "      <p>Hello, Escapes</p>\n"
                + "   </body>\n"
                + "</html>\n";
        System.out.println("String without text block:\n" + html);

        // With Text Blocks
        String tbhtml = """
                                <html>
                                    <body>
                                    <p>Hello, Text Blocks</p>
                                    </body>
                                </html>""";

        System.out.println("String with text block:\n" + tbhtml);
    }
}
