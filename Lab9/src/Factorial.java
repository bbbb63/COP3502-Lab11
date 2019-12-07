public class Factorial
{
    public static long pureRecursive (int n)
    {
        if (n < 0)
        {
            throw new IllegalArgumentException("Argument can not be negative"); // error for negative input.
        }

        if (n == 0)     // base case for factorial of 0.
        {
            return 1;   // factorial 0 results 1.
        }

        else
        {
            return n * pureRecursive(n - 1);    // recursive method call for factorial.
        }
    }
    public static long tailRecursive (int n )
    {
        if (n < 0)
        {
            throw new IllegalArgumentException("Argument can not be negative"); // error for negative input.
        }

        return tail(n, 1);  // calls auxiliary method tail for tail recursion method.
    }
    private static long tail (int n, long m)     // auxiliary method for computing factorial.
    {
        if (n < 0)
        {
            throw new IllegalArgumentException("Argument can not be negative"); // error for negative input.
        }

        if (n == 0)                             // base case for factorial of 0.
        {
            return m;                           // factorial 0 returns result of 1.
        }

        else
        {
            return tail(n - 1, n * m);  // recursive method call for factorial.
        }
    }
    public static long iterative (int n )
    {
        if (n < 0)
        {
            throw new IllegalArgumentException("Argument can not be negative"); // error for negative input.
        }

        long facResult = 1;                      // factorial of 0 is 1.

        for (int i = 1; i <= n; i ++)           // loop for computing factorial.
        {
            facResult = facResult * i ;         // compute factorial, increment number until n.
        }
        return facResult;                       // return result of factorial n.
    }

    public static void main (String[] args)
    {
        for (int i = -1; i <= 15; i++)
        {
            try                                 // test pureRecursive method input from -1 to 15.
            {                                   // output pureRecursive result for input i.
                System.out.println("pureRecursive output for " + i + " input: " + pureRecursive(i));
            }
            catch (Exception e)
            {
                System.out.println("pureRecursive error for " + i + " input");  // report error message for pureRecursive method.
            }

            try                                 // test tailRecursive method input from -1 to 15.
            {                                   // output tailRecursive result for input i.
                System.out.println("tailRecursive output for " + i + " input: " + tailRecursive(i));
            }
            catch (Exception e)
            {
                System.out.println("tailRecursive error for " + i + " input");  // report error message for tailRecursive method.
            }

            try                                 // test iterative method input from -1 to 15.
            {                                   // output iterative result for input i.
                System.out.println("Iterative output for " + i + " input: " + iterative(i));
            }
            catch (Exception e)
            {
                System.out.println("Iterative error for " + i + " input");      // report error message for iterative method.
            }
        }

    }
}
