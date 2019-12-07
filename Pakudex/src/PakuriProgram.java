import java.util.Arrays;
import java.util.Scanner;

public class PakuriProgram
{
    private static boolean checkInput(String input)             // This is method is to check what kind of input was entered.
    {
        boolean isNum = true;
        char[] charArray = input.toCharArray();

        for (int index = 0; index < charArray.length; index ++)
        {
            if (Character.isDigit(charArray[index]))            // to see if input is all digits.
            {

            }
            else if (!Character.isDigit(charArray[index]))      // to see if input contains any non digit.
            {
                isNum = false;
            }
        }
        return isNum;
    }
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean stopper = true, checker = true;
        int menuOpt = 0, maxCap = 0;
        String _input = "";

        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.print("Enter max capacity of the Pakudex: ");
        _input = input.next();

        while(checker)
        {
            if (checkInput(_input))                             // valid input, create Pakuri objects array.
            {
                maxCap = Integer.parseInt(_input);
                System.out.println("The Pakudex can hold " + maxCap + " species of Pakuri.");
                checker = false;
                break;
            }
            else if (!checkInput(_input))                       // invalid input, ask to input valid size again.
            {
                System.out.println("Please enter a valid size. ");
                System.out.print("Enter max capacity of the Pakudex: ");
                _input = input.next();
            }
        }

        Pakudex monsters = new Pakudex(maxCap);

        while (stopper)                                             // stop switch, option 6.
        {

            System.out.println("Pakudex Main Menu");                // line 57-64: options menus.
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit");
            System.out.print("What would you like to do? ");
            _input = input.next();

            if (!checkInput(_input))
            {
                System.out.println("Unrecognized menu selection!"); // unrecognized menu option.
                continue;
            }
            else if (checkInput(_input))                            // it already checked input is all digit.
            {
                menuOpt = Integer.parseInt(_input);                 // convert to digital values.
            }


            if (menuOpt == 6)                                       // option 6, exit program.
            {
                System.out.print("Thanks for using Pakudex! Bye!");
                stopper = false;
                break;
            }

            if (menuOpt == 1)                                       // option 1, list all Pakuri contained currently.
            {
                if (monsters.getSpeciesArray() == null)             // check if it is empty Pakuri array.
                {
                    System.out.println("No Pakuri in Pakudex yet!");
                }
                else if (monsters.getSpeciesArray() != null)        // if has Pakuri, output their names.
                {
                    System.out.println("Pakuri In Pakudex: ");
                    for (int index = 0; index < monsters.getSpeciesArray().length; index ++)
                    {
                        if (monsters.getSpeciesArray()[index] == null)
                        {
                            break;
                        }
                        System.out.println((index + 1) + "." + " " + monsters.getSpeciesArray()[index]);
                    }
                }
            }
            else if (menuOpt == 2)                                  // option 2, display specs of given Pakuri.
            {
                System.out.print("Enter the name of the species to display: ");
                _input = input.next();

                if (monsters.getStats(_input) == null)              // check if it is empty Pakuri array.
                {
                    System.out.println("Error: No such Pakuri!");
                    continue;
                }
                System.out.println("Species: " + _input);           // line 115-118: display specs.
                System.out.println("Attack: " + monsters.getStats(_input)[0]);
                System.out.println("Defense: " + monsters.getStats(_input)[1]);
                System.out.println("Speed: " + monsters.getStats(_input)[2]);
            }
            else if (menuOpt == 3)                                  // option 3, create Pakuri species.
            {
                if (monsters.getSize() == (maxCap) && (!monsters.addPakuri(_input)))
                {
                    System.out.println("Error: Pakudex is full!");  // check if it is full already.
                    continue;
                }

                System.out.print("Enter the name of the species to add: ");
                _input = input.next();


                if (!monsters.addPakuri(_input))                    // check if a species already existed.
                {
                    System.out.println("Error: Pakudex already contains this species!");
                }
                else
                {
                    System.out.println("Pakuri species " + _input + " successfully added!");
                }

            }
            else if (menuOpt == 4)                                  // option 4, evolve a given species.
            {
                System.out.print("Enter the name of the species to evolve: ");
                _input = input.next();

                if (monsters.getStats(_input) == null)              // no such species to evolve.
                {
                    System.out.println("Error: No such Pakuri!");
                }
                else if (monsters.evolveSpecies(_input))            // successful evolve.
                {
                    System.out.println(_input + " has evolved!");
                }

            }
            else if (menuOpt == 5)                                  // option 5, sort each Pakuri in lexicographical order.
            {
                monsters.sortPakuri();
                System.out.println("Pakuri have been sorted!");
            }
            else                                                    // any other unrecognized menu option input.
            {
                System.out.println("Unrecognized menu selection!");
            }
        }
    }
}
