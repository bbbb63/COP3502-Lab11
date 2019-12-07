import java.util.Scanner;

public class Hello {
    public static void main(String[] args){
        Scanner typeInVal = new Scanner(System.in); // use the scanner from java library.

        String name; // Assign name a string variable.
        String age;  // Assign age a string variable.
        String home; // Assign home a string variable.

        System.out.print("Hello. What is your name? "); // output on the screen.
        name = typeInVal.next(); // take an input.

        System.out.print("It's nice to meet you, " + name + "."); // output to the screen.
        System.out.print(" How old are you? "); // output to the screen.

        age = typeInVal.next(); // take an input.
        System.out.println("I see that you are still quite young at only " + age + "."); // output to the screen.

        System.out.print("Where do you live? "); // output to the screen.
        home = typeInVal.next(); // take an input.

        System.out.print("Wow! I've always wanted to go to " + home + ". Thanks for chatting with me. Bye! "); // output to the screen.

    }

}
