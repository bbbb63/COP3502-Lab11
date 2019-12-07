import java.util.*;
   public class powerExponent
{
  public static void main(String[] args)
   {

   Scanner obj1=new Scanner(System.in);

   System.out.println("enter the base:");

   int base=obj1.nextInt();

   Scanner obj2=new Scanner(System.in);

   System.out.println("enter the exponent:");

   int exp=obj2.nextInt();

   System.out.println("the result is " + pow(base,exp));

   }
    public static int pow(int base, int exp)
    {

        int product = base;

        if (exp == 0)
        {
            product = 1;
        }
        else {
            for (int i = 1; i < exp; i++)
            {
                product = product * base;
            }
        }

        return product;
   }
}