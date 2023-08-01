package BitManipulation;

public class ReverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int bits = 1 & (n >> i);
             res = res | (bits << (31 - i));
        }

        System.out.println(res);
    }
}
