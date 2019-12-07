
public class Cowsay
{
    private static void listCows(Cow[] cows)
    {
        for (int index = 0; index < cows.length; index++)
        {
            System.out.print(cows[index].getName() + " ");
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        Cow[] cowObjs = HeiferGenerator.getCows();                      // this is to create cow array of objects.

        String message = "";                                            // initialize message string.
        String pic = "";                                                // initialize image name.

        if(args[0].equals("-l"))                                        // to check if it is -l command, if so output cows options.
        {
            System.out.print("Cows available: ");
            listCows(cowObjs);
        }
        else if(args[0].equals("-n"))                                   // this is to check if it needs to choose different cows image.
        {

            pic = args[1];                                              // this is the input for cow image option.

            if (pic.equals("heifer"))                                   // if input is heifer, it displays the cow image.
            {
                for (int index = 2; index < args.length; index++)       // get the message.
                {
                    System.out.print(message + args[index] + " ");
                }
                System.out.println();

                System.out.println(cowObjs[0].getImage());              // display heifer image.
            }

            else if (pic.equals("kitteh"))                              // if input is kitteh, it displays the cat image.
            {
                for (int index = 2; index < args.length; index++)       // get the message.
                {
                    System.out.print(message + args[index] + " ");
                }
                System.out.println();
                System.out.println(cowObjs[1].getImage());
            }

            else                                                        // if it is not an image option, output the message.
            {
                System.out.println("Could not find " + pic + " cow!");
            }
        }

        else                                                            // every other input, use as message and display cow image.
        {
            for(int index = 0; index < args.length; index++)
            {
                message = message + args[index] + " ";
            }
            System.out.println(message);
            System.out.println(cowObjs[0].getImage());
        }
    }
}

