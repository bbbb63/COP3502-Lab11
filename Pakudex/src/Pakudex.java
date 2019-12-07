import java.util.ArrayList;

public class Pakudex
{
    private int capacity;
    private Pakuri[] _critters;

    public Pakudex()                                                // create default Pakuri objects of size 20.
    {
        _critters = new Pakuri[20];
    }

    public Pakudex(int capacity)                                    // create Pakuri objects of size provided by user.
    {
        this.capacity = capacity;
        _critters = new Pakuri[capacity];
    }

    public int getSize()                                            // get the size of Pakuri objects currently contained.
    {
        int counter = 0;
        for (int index = 0; index < _critters.length; index ++)
        {
            if (_critters[index] != null)
            {
                counter++;
            }
        }
        return counter;
    }

    public int getCapacity()                                        // get the max size of Pakuri object array.
    {
        this.capacity = _critters.length;
        return capacity;
    }

    public String[] getSpeciesArray()                               // get list of names of each Pakuri object.
    {
        ArrayList<String> names = new ArrayList<String>();          // to store names in the arraylist.

        int _nullCounter = 0;                                       // count null elements.

        for (int index = 0; index < getCapacity(); index ++)        // check if how many null elements.
        {
            if (_critters[index] == null)
            {
                _nullCounter = _nullCounter + 1;
            }
        }
        if (_nullCounter == getCapacity())                          // if all elements are null, return null.
        {
            return null;
        }
        else                                                        // extract name of each Pakuri object, until hits null.
        {
            for (int index = 0; index < getCapacity(); index ++)
            {
                if (_critters[index] == null)
                {
                    break;
                }
                else
                {
                    names.add(_critters[index].getSpecies());       // store name in names arraylist.
                }
            }
        }

        String[] objArray = new String[getCapacity()-_nullCounter]; // create a string array to output.
        for (int x = 0; x < names.size(); x++)                      // write names from arraylist to string array.
        {
            objArray[x] = names.get(x);
        }
        return objArray;
    }

    public int[] getStats(String species)                           // get specs values of each Pakuri object.
    {
        int index;
        int[] stats = new int[3];

        for (int a = 0; a < getSize(); a ++)                        // obtain attack, defense and speed values.
        {
            if (_critters[a].getSpecies().equals(species))          // store these values in an int array.
            {
                index = a;
                stats[0] = _critters[index].getAttack();
                stats[1] = _critters[index].getDefense();
                stats[2] = _critters[index].getSpeed();
                break;
            }
        }

        if (stats[0] == 0)                                          // to check if there are specs values at all.
        {
            return null;
        }
        return stats;
    }

    public void sortPakuri()                                        // sort Pakuri object in lexicographical order.
    {
        Pakuri temp = new Pakuri("");
        int swap;

        for (int a = 0; a < _critters.length - 1; a++)              // compare each element, outter loop.
        {
            swap = a;
            for (int b = a + 1; b < _critters.length; b++)          // innter loop elements.
            {
                if (_critters[b] == null)                           // if hits null, no more elements.
                {
                    break;
                }
                else if (_critters[b].getSpecies().compareTo(_critters[swap].getSpecies()) < 0)
                {
                    swap = b;                                       // to check which is placed front.
                }
            }
            temp = _critters[a];                                    // temp holder.
            _critters[a] = _critters[swap];                         // swap .
            _critters[swap] = temp;

        }

    }

    public boolean addPakuri(String species)                        // add single Pakuri object.
    {
        int index = getSize();                                      // index of Pakuri Array.
        boolean filled = true, repCheck = false;                    // fully filled tracker and repetitive tracker.

        for (int x = 0; x < index; x++)                             // check if a species already existed.
        {
            if (_critters[x].getSpecies().equals(species))
                repCheck = true;
        }

        if (index == capacity)                                      // check if object array is fully filled.
        {
            filled = false;
        }
        else if (index != 0 && repCheck)
        {
                filled = false;
        }
        else
        {
            _critters[index] = new Pakuri(species);                 // create new species.
            _critters[index].getAttack();                           // assign attack value.
            _critters[index].getDefense();                          // assign defense value.
            _critters[index].getSpeed();                            // assign speed value.
    }

        return filled;
    }

    public boolean evolveSpecies(String species)                    // evolve species.
    {
        for (int i = 0; i < getSize(); i++)
        {
            if (_critters[i].getSpecies().equals(species))
            {
                _critters[i].evolve();
                return true;
            }
        }
        return false;
    }
}
