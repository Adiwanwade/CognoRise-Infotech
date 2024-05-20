package task3;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
           
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            System.out.print("Enter the operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            // Perform arithmetic operation based on the operator
            double result;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator entered.");
            }

            // Display the result
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}

