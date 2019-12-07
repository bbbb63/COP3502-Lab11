import java.util.*;
import java.lang.*;

public class NumericConversion {

    public static String binaryToHex (String strToConvert){
                                                            // method to convert binary to hexadecimal.
        int sizeStr = strToConvert.length();                // get the size of the input string of binary.
        short tempDeciVal;
        String segStr, finalStrVal = "";

        if (sizeStr % 4 == 1){                              // partition the string to size of 4, check from the last index...
            strToConvert = '0' + '0' + '0' + strToConvert;  // if can not segment to size of 4 evenly, add zeros from beginning...
        }                                                   // to fill the position.
        else if (sizeStr % 4 == 2){
            strToConvert = '0' + '0' + strToConvert;
        }
        else if (sizeStr % 4 == 3){
            strToConvert = '0' + strToConvert;
        }

        while (strToConvert.length() != 0){                 // each conversion works with 4 binary numbers...

            segStr = strToConvert.substring(0,4);           // the segment of 4 binary being worked on
            tempDeciVal = binaryStringDecode(segStr);       // first obtain the decimal value of the 4 binary number.
                                                            // compare decimal value with hexadecimal, return the correct hex.
            if (tempDeciVal == 0){                          // line 27-74, compare and return the correct hex based on decimal value.
                segStr = Character.toString('0');
            }
            else if (tempDeciVal == 1){
                segStr = Character.toString('1');
            }
            else if (tempDeciVal == 2){
                segStr = Character.toString('2');
            }
            else if (tempDeciVal == 3){
                segStr = Character.toString('3');
            }
            else if (tempDeciVal == 4){
                segStr = Character.toString('4');
            }
            else if (tempDeciVal == 5){
                segStr = Character.toString('5');
            }
            else if (tempDeciVal == 6){
                segStr = Character.toString('6');
            }
            else if (tempDeciVal == 7){
                segStr = Character.toString('7');
            }
            else if (tempDeciVal == 8){
                segStr = Character.toString('8');
            }
            else if (tempDeciVal == 9){
                segStr = Character.toString('9');
            }
            else if (tempDeciVal == 10){
                segStr = Character.toString('A');
            }
            else if (tempDeciVal == 11){
                segStr = Character.toString('B');
            }
            else if (tempDeciVal == 12){
                segStr = Character.toString('C');
            }
            else if (tempDeciVal == 13){
                segStr = Character.toString('D');
            }
            else if (tempDeciVal == 14){
                segStr = Character.toString('E');
            }
            else if (tempDeciVal == 15){
                segStr = Character.toString('F');
            }

            finalStrVal += segStr;
            strToConvert = strToConvert.substring(4);       // get the substring for next 4 binary number until empty string.
        }

        return finalStrVal;
    }
    public static short binaryStringDecode(String strToConvert){
                                                            // method to convert string of binary to decimal.
        char singleChar;
        short biVal = 0, sum = 0, temp = 0;
        int indx;

        if (strToConvert.charAt(1) == 'b'){                 // if input starts with 0b, ignore it.
            strToConvert = strToConvert.substring(2);
        }
            indx = strToConvert.length();
        for (int i = 0; i < strToConvert.length(); i++){    // line 91-101, algorithm of the conversion.
            indx --;
            singleChar = strToConvert.charAt(indx);
            if (singleChar == '0'){
                biVal = 0;
            }
            else if (singleChar == '1'){
                biVal = 1;
            }
            temp = (short) ((biVal) * Math.pow(2,i));       // binary number conversion, base of 2.
            sum += temp;
        }
        return sum;
    }
    public static long hexStringDecode(String strToConvert){
                                                            // method to convert string of hexadecimal to decimal.
        long sum = 0, temp = 0;                             // line 107 - 113, algorithm of the conversion.
        int indx = strToConvert.length();

        for (int i = 0; i < strToConvert.length(); i++){
            indx --;
            temp = hexCharDecode(strToConvert.charAt(indx)) * (long)Math.pow(16, i); // base of 16 number.
            sum += temp;
        }
        return sum;
    }
    public static short hexCharDecode(char charOfStr){      // method to convert single char to decimal value.

        int charVal = 0;

        if (Character.isDigit(charOfStr) ){                 // if the char is single digit 0-9, decimal value is itself.
            charVal = Character.getNumericValue(charOfStr);
        }
        else if (Character.isLetter(charOfStr)){            // if the char is letter, return decimal value for that letter.
            switch (charOfStr){
                case 'A':
                case 'a':
                    charVal = 10;                           // letter a or A has decimal value of 10.
                    break;
                case 'B':
                case 'b':
                    charVal = 11;                           // letter b or B has decimal value of 11.
                    break;
                case 'C':
                case 'c':
                    charVal = 12;                           // letter c or C has decimal value of 12.
                    break;
                case 'D':
                case 'd':
                    charVal = 13;                           // letter d or D has decimal value of 13.
                    break;
                case 'E':
                case 'e':
                    charVal = 14;                           // letter e or E has decimal value of 14.
                    break;
                case 'F':
                case 'f':
                    charVal = 15;                           // letter f or F has decimal value of 15.
                    break;
            }
        }
        return (short)charVal;
    }
    public static void main (String[] args){

        Scanner input = new Scanner(System.in);
        boolean optFour = true;
        int menuOpt;
        long deciVal;
        String inputStr, result = "";

        while (optFour){                                 // start while loop for conversion.
            System.out.println("Decoding Menu");         // print menu and let user choose what to do.
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");

            System.out.println("Please enter an option: ");
            menuOpt = input.nextInt();

            if (menuOpt == 4){                           // if menu option 4 is chosen, program stops and say bye.
                System.out.println("Goodbye!");
                optFour = false;
                break;
            }

            System.out.println("Please enter the numeric string to convert: ");
            inputStr = input.next();                     // get input from user to convert.

            if (menuOpt == 1){
                deciVal = hexStringDecode(inputStr);     // if menu 1 is chosen, decode input hex to decimal.
                result = String.valueOf(deciVal);
            }
            else if (menuOpt == 2){
                deciVal = binaryStringDecode(inputStr);  // if menu 2 is chosen, decode input binary to decimal.
                result = String.valueOf(deciVal);
            }
            else if (menuOpt == 3){
                result = binaryToHex(inputStr);          // if menu 3 is chosen, decode input binary to hexadecimal.
            }

            System.out.println("Result: " + result);     // print out the result.
        }

    }
}
