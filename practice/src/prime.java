import java.util.*;

public class prime
{
    public static boolean isPrime(int num)
    {
    for (int i = 2; i < num; i++)
       
      if (num%i == 0)
        {
          return false;
        }
          return true;
    }
    public static void main(String[] args)
      {
      Scanner obj = new Scanner(System.in);

      System.out.println("enter a number");

      int num = obj.nextInt();

      if (isPrime(num)){
          System.out.println(num + " is prime number.");
      }
      else if (!isPrime(num)){
          System.out.println(num + " is not prime number.");
      }
      }
    }
