public class Dragon extends Cow
{

    private boolean whatDragon;

    public Dragon(String name, String image)
    {
        super(name);                            // get the dragon name and image, pass them on.
        super.setImage(image);                  // set the image based on the dragon.
    }

    public boolean canBreatheFire()
    {
        if (super.getName().equals("dragon"))   // check if the dragon breath fire.
        {
            whatDragon = true;
        }
        else
        {
            whatDragon = false;
        }
        return whatDragon;
    }
}
