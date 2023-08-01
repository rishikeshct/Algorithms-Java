package BitManipulation;

public class Count1Bits {
    public static void main(String[] args) {
        int n = 128;
        int count = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                count++;
            }
            n = n>>1;
        }

        System.out.println(count);


//        ---------------

         n = 128;
         count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n>>1;
        }

        System.out.println(count);

    }
}
