package basics.lambda;

import java.util.function.BiFunction;

public class Calculator {

    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public Integer operateBinaryLambda(int a, int b, BiFunction<Integer,Integer,Integer> op) {
        return op.apply(a, b);
    }

    public static void main(String... args) {

        Calculator myApp = new Calculator();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " +
                myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
                myApp.operateBinary(20, 10, subtraction));

        System.out.println("20 - 10 = " +
                myApp.operateBinaryLambda(20, 10, (a, b) -> a - b));
    }
}