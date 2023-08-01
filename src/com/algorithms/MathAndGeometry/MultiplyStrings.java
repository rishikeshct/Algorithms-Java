package MathAndGeometry;

public class MultiplyStrings {
    public static void main(String[] args) {

        String num1 = "1179", num2 = "88";

        System.out.println(MultiplyStringsFunc(num1, num2));
    }

    private static String MultiplyStringsFunc(String num1, String num2) {
        int[] ans = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i>= 0; i--) {
            for (int j =  num2.length() - 1; j >=0; j--) {
                int prod = ans[i+j+1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                ans[i+j+1] = prod % 10;
                ans[i+j] += prod / 10;
            }
        }

        StringBuilder str = new StringBuilder();
        int i = 0;
        for (i = 0; i < ans.length; i++) {
            if (ans[i] !=0){
               break;
            }
        }

        if (i == ans.length){
            str.append(0);
        }

        for (i = i; i <= num1.length() - 1 + num2.length() -1 + 1; i++) {
            str.append(ans[i]);
        }

        return str.toString();
    }
}
