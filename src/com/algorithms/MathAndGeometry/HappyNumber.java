package MathAndGeometry;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;

        System.out.println(HappyNumberFunc(n));
        System.out.println(HappyNumberFunc2(n));
    }

    private static boolean HappyNumberFunc(int n) {
            int slow=n;
            int fast=n;
            do{
                slow=sum(slow);
                fast=sum(sum(fast));
                if(slow==1)
                    return true;
            }while(slow!=fast);
            return false;
        }
        public static int sum(int n)
        {
            int sum =0;
            while(n>0){
                int rem = n%10;
                sum=sum+(rem*rem);
                n=n/10;
            }
            return sum;

    }

    private static boolean HappyNumberFunc2(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    public static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;

    }

}
