
import java.util.*;
import java.lang.*;

public class RleProgram{
    public static String toHexString(byte[] inData){
        final char[] hexRep = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', };
        String outString = "";                              // line 8-14:
        char indChar = ' ';                                 // go through the input flat data, write each element out as hex string.
        for (int i = 0; i < inData.length; i++){            // it can be RLE data, or flat data/
            indChar = hexRep[inData[i]];                    // then output the string.
            outString = outString + indChar;
        }
        return outString;
    }
    public static int countRuns(byte[] inData){             // line 17-43:
        int numRuns = 1, numSets = 0;                       // go through input flat data
        for (int i = 0; i < inData.length; i++){            // count the number of occurrence for a given pixel value.
            if (i == inData.length - 1){                    // the max occurrence is 15, if exceeded, recount as 1
                if (inData[i] == inData[i -1]){             // this is checking at the end condition equal or not
                    numRuns++;                              // if so, increase occurrence count
                    if (numRuns > 1){
                        numSets++;
                    }
                }
                else if (inData[i] != inData[i - 1]){
                    numSets++;
                }
                break;
            }
            else if (inData[i] == inData[i + 1]){
                numRuns++;
                if (numRuns > 15){
                    numSets++;
                    numRuns = 1;
                }
            }
            else if (inData[i] != inData[i + 1]){           // this is to check if current element is not the same as the next.
                numSets++;
                numRuns = 1;                                // then it knows it should start a new count
            }
        }
        return numSets;
    }
    public static byte[] encodeRle(byte[] inData){              // line 45-90
        byte[] outAry = new byte[2 * countRuns(inData)];        // encode flat data to RLE according to the rules
        byte numOccur = 1, eleVal = inData[0];
        ArrayList<Byte> RleList = new ArrayList<Byte>();

        for (int i = 0; i < inData.length; i++){                // go through the input flat data
            if (i == inData.length - 1 && inData[i] == inData[i - 1]){
                if (numOccur > 15){                             // check number of occurrence, if appeared more than 15,
                    numOccur = 15;                              // write the run as 15, that's the max, and its value
                    RleList.add(numOccur);
                    RleList.add(eleVal);
                    numOccur = 1;
                }
                else {
                    RleList.add(numOccur);
                    RleList.add(eleVal);
                }
            }
            else if (i == inData.length - 1 && inData[i] != inData[i - 1]){
                RleList.add(numOccur);                          // this is checking the end condition, see if it is a repeated number or new number
                RleList.add(eleVal);
                numOccur = 1;
                eleVal = inData[i];
            }
            else if (inData[i] == inData[i + 1]){
                numOccur++;
                eleVal = inData[i];
                if (numOccur > 15){                             // this is checking the end condition, see if the last one is the 15th occurrence.
                    numOccur = 15;
                    RleList.add(numOccur);
                    RleList.add(eleVal);
                    numOccur = 1;
                }
            }
            else if (inData[i] != inData[i + 1]){
                RleList.add(numOccur);
                RleList.add(eleVal);
                numOccur = 1;
                eleVal = inData[i + 1];
            }
        }
        for (int a = 0; a < outAry.length; a++){                // write all values from array list into the output array.
            outAry[a] = RleList.get(a);
        }
        return outAry;
    }
    public static int getDecodedLength(byte[] inData){
        int lengthSum = 0;                                      // get the total run length.
        for (int i = 0; i < inData.length; i += 2){             // just add up all the even index numbers to get total length.
            lengthSum += inData[i];                             // this later is to be used to create array with the right size.
        }
        return lengthSum;
    }
    public static byte[] decodeRle(byte[] inData){
        byte[] outAry = new byte[getDecodedLength(inData)];     // line 99-109
        byte eleVal, numOccur;                                  // this is to decode RLE data to flat data.
        ArrayList<Byte> valList = new ArrayList<Byte>();

        for (int i = 0; i < inData.length; i += 2){             // go through the RLE data array, get number of occurrence and value
            numOccur = inData[i];                               // write them out into array list
            eleVal = inData[i + 1];                             // start with the current value as occurrence and next element as the value.
            for (int a = 1; a <= numOccur; a++){
                valList.add(eleVal);
            }
        }
        for (int b = 0; b < outAry.length; b++){                // write each value in the array list into the output array.
            outAry[b] = valList.get(b);
        }
        return outAry;
    }
    public static byte[] stringToData(String inDataStr){
        final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', };
        final byte[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int numIdx = 0;
        char oneChar = ' ';
        byte[] outAry = new byte[inDataStr.length()];           // convert string of hex data to flat data.

        for (int i = 0; i < inDataStr.length(); i++){           // go through the input data string,
            oneChar = inDataStr.charAt(i);                      // check to see what the char is, and get its value
            for (int a = 0; a < hex.length; a++){               // write the value of each into the output array.
                if (oneChar == hex[a]){
                    numIdx = a;
                }
            }
            outAry[i] = num[numIdx];
        }
        return outAry;
    }
    public static String toRleString(byte[] inData){
        final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', };
        final byte[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        String outStr = "",temp = "";

        for (int i = 0; i < inData.length; i++){                    //  line 138-151:
            if (i % 2 == 0){                                        // go through input byte array to get run length and pixel value
                temp = String.valueOf(num[inData[i]]);              // even number index is run length.
            }                                                       // odd number index is pixel value.
            else if (i % 2 != 0){                                   // write out the length and values with delimiter :
                if (i == inData.length - 1){
                    temp = String.valueOf(hex[inData[i]]);
                }
                else {
                    temp = String.valueOf(hex[inData[i]] + ":");
                }
            }
            outStr = outStr + temp;
        }
        return outStr;
    }
    public static byte[] stringToRle(String rleStr){
        final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', };
        final byte[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        String[] segStr = rleStr.split(":");                // segment input RLE string by :
        String oneSegStr;                                          // one segment of RLE string.
        ArrayList<Byte> rleList = new ArrayList<Byte>();
        byte[] outAry = new byte[2 * segStr.length];               // get the size of output array.
        int charInd = 0, hexVal = 0, lenInd = 0, lenVal = 0;

        for (int i = 0; i < segStr.length; i++) {                   // line 164-196:
            oneSegStr = segStr[i];                                  // go through each string segment
                                                                    // if length of 2, index 0 is run length and index 1 is value
            if (oneSegStr.length() == 2) {                          // if length of 3, index 0,1 is run length and index 2 is value
                for (int a = 0; a < hex.length; a++) {              // get the run length and value accordingly based on segment
                    if (oneSegStr.charAt(1) == hex[a]) {            // store the run length value and pixel value in array list.
                        charInd = a;
                        hexVal = num[a];
                    }
                }
                for (int b = 0; b < hex.length; b++) {
                    if (oneSegStr.charAt(0) == hex[b]) {
                        lenInd = b;
                        lenVal = num[b];
                    }
                }
            }

            else if (oneSegStr.length() == 3) {
                for (int c = 0; c < hex.length; c++) {
                    if (oneSegStr.charAt(2) == hex[c]) {
                        charInd = c;
                        hexVal = num[c];
                    }
                }

                for (int d = 0; d < hex.length; d++) {
                    if (oneSegStr.charAt(1) == hex[d]) {
                        lenInd = d + 10;
                        lenVal = num[lenInd];
                    }
                }
            }

            rleList.add((byte) lenVal);
            rleList.add((byte) hexVal);
        }
        for (int x = 0; x <outAry.length; x ++){                    // get each value from array list to output.
            outAry[x] = rleList.get(x);
        }
        return outAry;
    }
    public static void main (String[] arg){

        Scanner userInput = new Scanner(System.in);                     // use scanner from java.
        boolean stopperOpt = true;                                      // stopper, true turn to false when op 0 chosen.
        int menuOpt;                                                    // menu variable.
        byte[] flatData = null;                                         // universal variable for flat data storage.
        String fileName = " ", strData = " ";                           // input file name and input string variables.

        System.out.println("Welcome to the RLE image encoder!\n");
        System.out.println("Displaying Spectrum Image: ");
        ConsoleGfx.displayImage(ConsoleGfx.testRainbow);                // display the test rainbow thing.
        System.out.println();

        while (stopperOpt){                                             // if stopper is true, keep going.
            System.out.println("RLE Menu");                             // line 224-238
            System.out.println("--------");                             // RLE menu options..
            System.out.println("0. Exit ");
            System.out.println("1. Load File ");
            System.out.println("2. Load Test Image ");
            System.out.println("3. Read RLE String ");
            System.out.println("4. Read RLE Hex String ");
            System.out.println("5. Read Data Hex String ");
            System.out.println("6. Display Image ");
            System.out.println("7. Display RLE String ");
            System.out.println("8. Display Hex RLE Data ");
            System.out.println("9. Display Hex Flat Data ");
            System.out.println();
            System.out.println("Select a Menu Option: ");
            menuOpt = userInput.nextInt();

            if (menuOpt == 0){                                          // if op 0 chosen, stopper becomes false.
                stopperOpt = false;
                break;
            }
            else if (menuOpt == 1){                                     // op 1, get filename as input, load that file then.
                System.out.print("Enter name of file to load: ");
                fileName = userInput.next();
                flatData = ConsoleGfx.loadFile(fileName);
                System.out.println();
            }
            else if (menuOpt == 2){                                     // op 2, load pre-set test image data.
                flatData = ConsoleGfx.testImage;
                System.out.println("Test image data loaded.");
            }
            else if (menuOpt == 3){                                     // op 3, enter RLE w/ :, convert to flat data.
                System.out.print("Enter an RLE string to be decoded: ");
                strData = userInput.next();
                flatData = decodeRle(stringToRle(strData));
            }
            else if (menuOpt == 4){                                     // op 4, enter RLE hex data, convert to flat data.
                System.out.print("Enter the hex string holding RLE data: ");
                strData = userInput.next();
                flatData = decodeRle(stringToData(strData));
            }
            else if (menuOpt == 5){                                     // op 5, enter flat hex data, convert to flat data.
                System.out.print("Enter the hex string holding flat data: ");
                strData = userInput.next();
                flatData = stringToData(strData);
            }
            else if (menuOpt == 6){                                     // op 6, display image of current flat data.
                System.out.println("Displaying image...\n");
                ConsoleGfx.displayImage(flatData);
                continue;
            }
            else if (menuOpt == 7){                                     // op 7, output RLE w/ : from flat data.
                System.out.print("RLE representation: ");
                System.out.println(toRleString(encodeRle(flatData)));
            }
            else if (menuOpt == 8){                                     // op 8, output RLE hex data w/o : from flat data.
                System.out.print("RLE hex values: ");
                System.out.println(toHexString(encodeRle(flatData)));
            }
            else if (menuOpt == 9){                                     // op 9, output current flat data as hex data.
                System.out.println("Flat hex values: " + toHexString(flatData));
            }
        }
    }
}