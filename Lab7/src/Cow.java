public class Cow
{
    private String image;
    private String name;

    public Cow(String name)
    {
        this.name = name;               // get input name for the cow.
    }

    public String getName()
    {
        return name;                    // return cow's name.
    }

    public String getImage()
    {
        return image;                   // return cow's image.
    }

    public void setImage(String image)
    {
        this.image = image;             // set cow's image based on the name of cow.
    }
}
