
public class Cowsay
{
    public static void listCows(Cow[] cows)
    {
        for (int index = 0; index < cows.length; index++)               // method for getting all names of cows.
        {
            System.out.print(cows[index].getName() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Cow[] cowObjs = HeiferGenerator.getCows();                                      // this is to create cow array of objects.
        Cow dragonObjs = new IceDragon("dragon", cowObjs[2].getImage());         // create dragon objects.
        Cow IceDragonObjs = new IceDragon("ice-dragon", cowObjs[2].getImage());  // create dragon objects.

        String message = "";                                                            // initialize message string.
        String pic = "";                                                                // initialize image name.
        String allCows = "heifer kitteh dragon ice-dragon";                             // list of cow names.

        if(args[0].equals("-l"))                                                        // to check if it is -l command, if so output cows options.
        {
            System.out.print("Cows available: ");
            listCows(cowObjs);
        }
        else if(args[0].equals("-n"))                                                   // this is to check if it needs to choose different cows image.
        {

            pic = args[1];                                                              // this is the input for cow image option.

            if (allCows.contains(pic) == false)                                         // if no cow name exist, print default.
            {
                System.out.println("Could not find " + pic + " cow!");
            }

            else
            {
                for (int index = 2; index < args.length; index++)                       // get the message.
                {
                    System.out.print(message + args[index] + " ");
                }
                System.out.println();

                if (pic.equals("heifer"))                                               // if input is heifer, it displays the cow image.
                {
                    System.out.println(cowObjs[0].getImage());                          // display heifer image.
                }

                else if (pic.equals("kitteh"))                                          // if input is kitteh, it displays the cat image.
                {
                    System.out.println(cowObjs[1].getImage());                          // display cat image.
                }

                else if (pic.equals("dragon"))                                          // if input is dragon, displays the dragon image.
                {
                    System.out.println(dragonObjs.getImage());
                    System.out.println("This dragon can breath fire.");                 // tell the dragon can breathe fire.
                }

                else if (pic.equals("ice-dragon"))                                      // if input is ice-dragon, displays the dragon image.
                {
                    System.out.println(IceDragonObjs.getImage());
                    System.out.println("This dragon cannot breathe fire.");             // tell the dragon cant breathe fire.
                }
            }
        }

        else                                                                            // every other input, use as message and display cow image.
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
