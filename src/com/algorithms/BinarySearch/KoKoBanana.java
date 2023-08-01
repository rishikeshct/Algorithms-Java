package BinarySearch;

public class KoKoBanana {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

        System.out.println(KoKoBananaFunc(piles, h));
    }

    private static int KoKoBananaFunc(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        int minEat = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int  i =0; i < piles.length; i++) {
                sum += piles[i]%mid==0?piles[i]/mid:(piles[i]/mid) + 1;
            }
            if (sum > h) {
                left = mid + 1;
            } else {
                minEat = mid;
                right = mid - 1;
            }
        }
        return minEat;
    }
}
