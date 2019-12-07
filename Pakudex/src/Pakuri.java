public class Pakuri
{
    private String species;
    private int attack, defense, speed;

    public Pakuri(String species)               // constructor for creating Pakuri object.
    {
        this.species = species;                 // Pakuri object name.
        attack = (species.length() * 7) + 9;    // initial attack value.
        defense = (species.length() * 5) + 17;  // initial defense value.
        speed = (species.length() * 6) + 13;    // initial speed value.
    }

    public String getSpecies()
    {
        return species;                         // get Pakuri object's name.
    }

    public int getAttack()                      // get attack value.
    {
        return attack;
    }

    public int getDefense()                     // get defense value.
    {
        return defense;
    }

    public int getSpeed()                       // get speed value.
    {
        return speed;
    }

    public void setAttack(int newAttack)        // to set new attack value.
    {
        this.attack = newAttack;
    }

    public void evolve()                        // evolve to set new values for attack, defense and speed.
    {
        setAttack(attack * 2);
        this.defense = defense * 4;
        this.speed = speed * 3;
    }
}
