/**
 * 
 * javac --enable-preview --source 23 .\PrimitiveTypeInstanceOfExample.java
 * Note: .\PrimitiveTypeInstanceOfExample.java uses preview features of Java SE 23.
 * Note: Recompile with -Xlint:preview for details.
 * 
 * java --enable-preview PrimitiveTypeInstanceOfExample  
 * 
 * The output:
 * given a number: 32
 * Number fits a byte:32
 * Another number: 100000
 * Number is an int:100000
 */
public class PrimitiveTypeInstanceOfExample {
    public static void main(String[] args) {
        System.out.println("given a number: 32");
        instanceOf(32);
        System.out.println("Another number: 100000");
        instanceOf(100_000);
    }

    static void instanceOf(int number) {
        if( number instanceof byte b) {
            System.out.println("Number fits a byte:" + b);
        }else if( number instanceof short s) {
            System.out.println("Number fits a short:" + s);
        }else {
            System.out.println("Number is an int:" + number);
        }
    }
}
