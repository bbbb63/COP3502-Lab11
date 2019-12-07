import java.util.Scanner;
import java.lang.*;

public class SciCalculator {

    public static double add (double a, double b){          // method to compute addition, return the value of addition.
        return a + b;
    }
    public static double minus (double a, double b){        // method to compute subtraction, return the value of subtraction.
        return a - b;
    }
    public static double multiply (double a, double b){     // method to compute multiplication, return the value of multiplication.
        return a * b;
    }
    public static double divide (double a, double b){       // method to compute division, return the value of division.
        return a / b;
    }
    public static double expo (double a, double b){         // method to compute exponentiation, return the value of exponentiation.
        return Math.pow(a, b);
    }
    public static double logrithm (double a, double b){     // method to compute logarithm, return the value of logarithm.
        return (Math.log(b)) / (Math.log(a));
    }
    public static void main (String[] args){

        boolean optZero = true;                  // declare variable for option 0 as stop condition.
        double result = 0, sumCalc = 0;          // declare variables for current value and sum of all calculations.
        int numCalc =0;                          // declare variable for total number of calculations performed.
        double numA, numB, menuOption = 0;       // declare variable for operands, and menu options.
        Scanner input = new Scanner(System.in);  // to use the scanner.

        System.out.println("Current Result: " + result);   // print current result.
        System.out.println("Calculator Menu");             // line 33-42, print the menu options.
        System.out.println("---------------");
        System.out.println("0. Exit Program");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Logarithm");
        System.out.println("7. Display Average");

        while (optZero){                                                                         // if opt 0 is chosen, stop running.
            System.out.println("Enter Menu Selection: ");                                        // prompt to enter menu option.
            menuOption = input.nextInt();                                                        // take value to choose menu option.

            if (menuOption == 0){                                                                // if 0 is chosen, stop the calculator.
                optZero = false;
                System.out.println("Thanks for using this calculator. Goodbye!");
                break;
            }
            else if (menuOption ==7){                                                            // if 7 is chosen, compute average.
                if (sumCalc == 0 && numCalc ==0){                                                // if there is no value to average, then...
                    System.out.println("Error: No calculations yet to average!");                // output error message for no calculation.
                    continue;
                }
                else {                                                                           // if there is value to calculate average, do..
                    System.out.println("Sum of calculations: " + sumCalc);                       // the calculation and output values as required.
                    System.out.println("Number of calculations: " + numCalc);
                    System.out.format("Average of calculations: %.2f", (sumCalc) / (numCalc));
                    continue;
                }

            }
            else if (menuOption<0 || menuOption>6){                // check if input is valid for menu selection. if not, output error.
                System.out.println("Error: Invalid selection!");
                continue;
            }
            else {

            }
            while (menuOption >= 1 || menuOption <= 6){            // if menu selection is valid, perform the operation.
                System.out.println("Enter first operand: ");       // prompt to enter 1st operand.
                numA = input.nextDouble();                         // enter first operand.
                System.out.println("Enter second operand: ");      // prompt to enter 2nd operand.
                numB = input.nextDouble();                         // enter second operand.

                if (menuOption == 1){                // if option 1 is chosen, perform addition and return sum.
                    result = add(numA, numB);
                }
                else if (menuOption == 2){           // if option 2 is chosen, perform subtraction and return difference.
                    result = minus(numA, numB);
                }
                else if (menuOption == 3){           // if option 3 is chosen, perform multiplication and return product.
                    result = multiply(numA, numB);
                }
                else if (menuOption == 4){           // if option 4 is chosen, perform division and return quotient.
                    result = divide(numA, numB);
                }
                else if (menuOption == 5){           // if option 5 is chosen, perform exponentiation and return the value.
                    result = expo(numA, numB);
                }
                else if (menuOption == 6){           // if option 6 is chosen, perform logarithm and return the value.
                    result = logrithm (numA, numB);
                }
                System.out.println("Current Result: " + result);     // print out the value of current result.
                sumCalc = sumCalc + result;                          // record the all values as sum of all calculations.
                numCalc++;                                           // record the total number of calculations performed.
                break;
            }

            System.out.println("Calculator Menu");                   // line 103-112, print out the calculator menu.
            System.out.println("---------------");
            System.out.println("0. Exit Program");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exponentiation");
            System.out.println("6. Logarithm");
            System.out.println("7. Display Average");

        }
    }
}