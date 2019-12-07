import java.util.*;

public class digitCheck {
    public static boolean allDigitsOdd (int num)
    {
        if (num%10 == 0 && (num%10)%2 == 0)
        {
            return false;
        }
        while(num%10 != 0)
        {
            int digit = num % 10;
            if (digit % 2 == 0)
            {
                return false;
            }
            num = num / 10;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("enter a number to check");
        int num = input.nextInt();

        if(allDigitsOdd(num)){
            System.out.println("all digits are odd.");
        }
        else if (!allDigitsOdd(num)){
            System.out.println("not all digits are odd.");
        }
    }
}
