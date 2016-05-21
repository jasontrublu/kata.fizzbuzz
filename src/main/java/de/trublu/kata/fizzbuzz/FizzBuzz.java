package de.trublu.kata.fizzbuzz;

import java.util.stream.IntStream;

public class FizzBuzz {

    private static final String NEWLINE = "\n";

    public static String print(int max) {
        return IntStream.rangeClosed(1, max)
                .mapToObj(FizzBuzz::transform)
                .reduce((result, current) -> result + NEWLINE + current)
                .orElse("");
    }

    public static String transform(int input) {
        String result = "";
        result = replaceFizz(input, result);
        result = replaceBuzz(input, result);
        result = replaceFaceValue(input, result);
        return result;
    }

    private static String replaceFaceValue(int input, String result) {
        if (result.isEmpty()) {
            result = String.valueOf(input);
        }
        return result;
    }

    private static String replaceFizz(int input, String result) {
        if (isDivisibleByThree(input)) {
            result += "Fizz";
        }
        return result;
    }

    private static String replaceBuzz(int input, String result) {
        if (isDivisibleByFive(input)) {
            result += "Buzz";
        }
        return result;
    }

    private static boolean isDivisibleByFive(int input) {return isDivisibleBy(5, input);}

    private static boolean isDivisibleByThree(int input) {return isDivisibleBy(3, input);}

    private static boolean isDivisibleBy(int divisor, int input) {return input % divisor == 0;}
}
