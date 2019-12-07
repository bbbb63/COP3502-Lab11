public class IceDragon extends Dragon
{

    private boolean kindDragon;

    public IceDragon(String name, String image)
    {
        super(name, image);                         // get the dragon name and image, pass them on
        super.setImage(image);                      // set the image based on the dragon
    }
    public boolean canBreatheFire()
    {
        if (super.getName().equals("ice-dragon"))   // check if the dragon breath fire.
        {
            kindDragon = true;
        }
        else
        {
            kindDragon = false;
        }
        return kindDragon;
    }
}

