import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Simple Calculator Program
 * -------------------------
 * A console-based calculator that performs basic arithmetic operations
 * (addition, subtraction, multiplication, division, modulus).
 * It uses Scanner for input and exception handling for invalid input
 * such as division by zero or non-numeric entries.
 */
public class SimpleCalculator {

    // ---------- Arithmetic methods ----------

    // Returns the sum of two numbers
    static double add(double a, double b) {
        return a + b;
    }

    // Returns the difference of two numbers
    static double subtract(double a, double b) {
        return a - b;
    }

    // Returns the product of two numbers
    static double multiply(double a, double b) {
        return a * b;
    }

    // Returns the quotient; throws ArithmeticException if divisor is zero
    static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    // Returns the remainder; throws ArithmeticException if divisor is zero
    static double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Modulus by zero is not allowed.");
        }
        return a % b;
    }

    // ---------- Menu display ----------

    // Prints the list of available operations
    static void showMenu() {
        System.out.println("\n===== SIMPLE CALCULATOR =====");
        System.out.println("1. Addition       (+)");
        System.out.println("2. Subtraction    (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division       (/)");
        System.out.println("5. Modulus        (%)");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");
    }

    // ---------- Main program ----------

    public static void main(String[] args) {
        // Scanner reads user input from the console
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Java Console Calculator!");

        // Loop keeps the calculator running until the user chooses Exit
        while (running) {
            showMenu();

            try {
                // Read the user's menu choice
                int choice = scanner.nextInt();

                // Exit option
                if (choice == 6) {
                    System.out.println("Thank you for using the calculator. Goodbye!");
                    running = false;
                    continue;
                }

                // Validate that the choice is within the menu range
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid choice! Please select a number between 1 and 6.");
                    continue;
                }

                // Read the two operands from the user
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result = 0;
                String symbol = "";

                // Perform the selected operation
                switch (choice) {
                    case 1:
                        result = add(num1, num2);
                        symbol = "+";
                        break;
                    case 2:
                        result = subtract(num1, num2);
                        symbol = "-";
                        break;
                    case 3:
                        result = multiply(num1, num2);
                        symbol = "*";
                        break;
                    case 4:
                        result = divide(num1, num2);   // may throw ArithmeticException
                        symbol = "/";
                        break;
                    case 5:
                        result = modulus(num1, num2);  // may throw ArithmeticException
                        symbol = "%";
                        break;
                }

                // Display the result clearly
                System.out.println("\nResult: " + num1 + " " + symbol + " " + num2 + " = " + result);

            } catch (ArithmeticException e) {
                // Handles division/modulus by zero
                System.out.println("Error: " + e.getMessage());

            } catch (InputMismatchException e) {
                // Handles non-numeric input (e.g., letters instead of numbers)
                System.out.println("Error: Invalid input! Please enter numeric values only.");
                scanner.nextLine(); // clear the invalid token from the input buffer
            }
        }

        // Release the scanner resource
        scanner.close();
    }
}
