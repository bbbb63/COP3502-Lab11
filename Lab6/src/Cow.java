public class Cow
{
    private String picture;                 // declare private variable used image name.
    private String Name;                    // declare private variable used for name of cows.

    public Cow(String name)
    {
        this.Name = name;                   // name is used when creating cows array of objects.
    }

    public String getName()
    {
        return Name;                        // get the name of cow from cows objects.
    }

    public String getImage()
    {
        return picture;                     // get the image from cows objects.
    }

    public void setImage(String picture)
    {
        this.picture = picture;             // to set image in cows objects to proper images.
    }

}
