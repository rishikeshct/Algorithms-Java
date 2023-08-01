package BitManipulation;

public class Addition {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;

        while (b != 0) {
            int tmp = a & b << 1;
            a = a ^ b;
            b = tmp;
        }

        System.out.println(a);

    }
}
