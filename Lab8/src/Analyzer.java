public class Analyzer {

    public static int linearSearch(String[] dataSet, String element)
    {
        int keyInd = -1;                                        // this is the linear search method.

        for (int index = 0; index < dataSet.length; index ++)   // loop through the search base.
        {
            if (dataSet[index].equals(element))                 // compare the key with each element.
            {
                keyInd = index;                                 // if find, output the index of key.
            }
        }
        return keyInd;
    }
    public static int binarySearch(String[] dataSet, String element)
    {
        int low = 0;                                        // this is the binary search method.
        int high = dataSet.length - 1;
        int mid;
        int keyInd = -1;

        while (high>= low)                                  // to check if there is still elements to be searched.
        {
            mid = (high + low)/2;                           // find the middle index.

            if (dataSet[mid].equals(element))               // compare the middle element with key.
            {
                keyInd = mid;                               // if find it, output the index.
                return keyInd;
            }
            else if (dataSet[mid].compareTo(element) < 0)   // to eliminate first half, check in second half.
            {
                low = mid + 1;
            }
            else if (dataSet[mid].compareTo(element) > 0)   // to eliminate second half, check in first half.
            {
                high = mid - 1;
            }
        }
        return keyInd;
    }
    public static void main (String[] args)
    {
        String[] entryArray = StringData.getData();                 // search base provided by StringData.
        String[] keyArray = {"not_here", "mzzzz", "aaaaa"};         // keywords array.
        long start_time, end_time, index;                           // time tracker and index of keywords.

        for (int i = 0; i < keyArray.length; i++)                   // line 49-57: search each keyword in search base,
        {                                                           // using linear search method, keep track of execution time.
            System.out.println("Key to search for: " + keyArray[i]);
            start_time = System.nanoTime();
            index = linearSearch(entryArray, keyArray[i]);
            end_time = System.nanoTime();
            System.out.println("Key is found at index " + index);
            System.out.println("Execution time using Linear Search method is " + (end_time - start_time) + " nano seconds.");
            System.out.println();
        }

        for (int i = 0; i < keyArray.length; i++)                   // line 60-68: search each keyword in search base,
        {                                                           // using binary search method, keep track of execution time.
            System.out.println("Key to search for: " + keyArray[i]);
            start_time = System.nanoTime();
            index = binarySearch(entryArray, keyArray[i]);
            end_time = System.nanoTime();
            System.out.println("Key is found at index " + index);
            System.out.println("Execution time using Binary Search method is " + (end_time - start_time) + " nano seconds.");
            System.out.println();
        }

    }
}
