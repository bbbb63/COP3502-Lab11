import java.util.Scanner;                       // to use the scanner from JDK.

public class Calculator {
   public static void main(String[] args){
      Scanner inCmd = new Scanner(System.in);   // declare scanner to take input.

      double firstOp;               // declare first operand variable.
      double secondOp;              // declare second operand variable.
      int choice;                   // number to choose from the menu.
      double sum, difr, prd, qtion; // declare four operations.

      System.out.print("Enter first operand: ");  // prompt to enter first operand.
      firstOp = inCmd.nextDouble();               // enter the first operand.
      System.out.print("Enter second operand: "); // prompt to enter second operand.
      secondOp = inCmd.nextDouble();              // enter the second operand.

      System.out.println("");
      System.out.println("Calculator Menu");   // print the menu.
      System.out.println("---------------");
      System.out.println("1. Addition");       // choice to perform addition.
      System.out.println("2. Subtraction");    // choice to perform subtraction.
      System.out.println("3. Multiplication"); // choice to perform multiplication.
      System.out.println("4. Division");       // choice to perform division.
      System.out.println("");

      System.out.print("Which operation do you want to perform? "); // choose which operation to perform.
      choice = inCmd.nextInt();                                     // choose from menu.
      System.out.println("");

      if (choice == 1){
         sum = firstOp + secondOp;
         System.out.print("The result of the operation is " + sum + ". Goodbye!");   // if 1 is chosen, do additon and output.
      }
      else if (choice == 2){
         difr = firstOp - secondOp;
         System.out.print("The result of the operation is " + difr + ". Goodbye!");  // if 2 is chosen, do substraction and output.
      }
      else if (choice == 3){
         prd = firstOp * secondOp;
         System.out.print("The result of the operation is " + prd + ". Goodbye!");   // if 3 is chosen, do multiplication and output.
      }
      else if (choice == 4){
         qtion = firstOp / secondOp;
         System.out.print("The result of the operation is " + qtion + ". Goodbye!"); // if 4 is chosen, do division and output.
      }
      else {
         System.out.print("Error: Invalid selection! Terminating program.");         // if othes are chosen, output error message.
      }
   }


}
