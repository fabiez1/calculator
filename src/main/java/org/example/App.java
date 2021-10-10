package org.example;

import java.util.Scanner;

public class App
    {
    public static Scanner SCANNER = new Scanner(System.in);

    public static void main( String[] args )
    {
        System.out.println("***************************************************\n** Calculator *************************************\n***************************************************");
        boolean isPlaying = true;

        while(isPlaying) {
            long num1 = userInputInt();

            String operator = userInputString();

            long num2 = userInputInt();
            if (num2 == 0 && operator.equals("/")) {
                System.err.println("The second number can't be 0 in division");
            } else {
                mathCalculation(num1, num2, operator);
            }

            calculateOrQuit();
        }
    }

    public static void calculateOrQuit() {
        boolean isCalculateOrQuitPlaying = true;

        while(isCalculateOrQuitPlaying) {
            System.out.println("\nDo you wanna (c)alculate some more or (q)uit? (c/q)");
            String decision = SCANNER.nextLine();

            if (decision.equals("q") || decision.equals("Q")) {
                System.out.println("Good bye");
                System.exit(0);
            } else if (decision.equals("c") || decision.equals("C")) {
                isCalculateOrQuitPlaying = false;
            } else {
                System.err.println("Not a supported character");
            }
        }
    }

    public static void mathCalculation(long num1, long num2, String operator) {
        long sum = 0;

        switch(operator) {
            case "/":
                sum = num1 / num2;
                break;
            case "*":
                sum = num1 * num2;
                break;
            case "+":
                sum = num1 + num2;
                break;
            case "-":
                sum = num1 - num2;
                break;
        }
        System.out.println(num1 + " " + operator + " " + num2 + " = " + sum);
    }

    public static String userInputString() {
        String operator = null;
        boolean isUserInputStringPlaying = true;

        while(isUserInputStringPlaying) {
            System.out.println("\nInsert an operator as either /, *, + or -");
            operator = SCANNER.nextLine();

            if (operator.equals("/") || operator.equals("*") || operator.equals("+") || operator.equals("-")) {
                isUserInputStringPlaying = false;
            } else {
                System.err.println("Not a supported character");
            }
        }
        return operator;
    }

    public static Long userInputInt() {
        System.out.println("\nInsert a number");
        return Long.parseLong(SCANNER.nextLine());
    }
}
