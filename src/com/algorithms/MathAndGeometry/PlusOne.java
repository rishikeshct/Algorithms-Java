package MathAndGeometry;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {9,9,9};

        PlusOneFunc(digits);
        System.out.println(Arrays.toString(digits));
    }

    private static int[] PlusOneFunc(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
