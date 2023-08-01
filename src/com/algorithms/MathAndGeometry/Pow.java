package MathAndGeometry;

public class Pow {
    public static void main(String[] args) {

        System.out.println(myPow(2,-4));

        System.out.println(myPowRecursion(2,-4));


    }

    private static double myPowRecursion(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / myPowRecursion(x, -n);

        }
        if (n % 2 == 0) {
            double temp = myPowRecursion(x, n/2);
            return temp * temp;
        } else {
            return x * myPowRecursion(x, n-1);
        }
    }

    public static double myPow(double x, int n) {
            // Base case: If n is 0, return 1
            if (n == 0) {
                return 1;
            }

            // For negative exponents, invert x and make n positive
            if (n < 0) {
                x = 1 / x;
                n = -n;
            }

            double result = 1;
            double current = x;

            // Multiply current by x for each bit set in n
            while (n > 0) {
                if (n % 2 == 1) {
                    result *= current;
                }
                current *= current;
                n /= 2;
            }

            return result;
        }
}
