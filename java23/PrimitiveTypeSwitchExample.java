public class PrimitiveTypeSwitchExample {
    public static void main(String[] args) {
        System.out.println("Given 0.0:");
        switchFloat(0.0f);
        System.out.println("Input 3.14f:");
        switchFloat(3.14f);
        System.out.println("Input -0.1:");
        switchFloat(-0.1f);
        System.out.println("Input 0.1f:");
        switchFloat(0.1f);
    }

    static void switchFloat(Float floatValue) {
        switch (floatValue) {
            case 0f -> System.out.println("Zero");
            case 3.14f -> System.out.println("Pi");
            case float f when f<0 -> System.out.println("Negative float:" + f);
            case float f -> System.out.println("Positive float:" +f);
        }
    }

}
