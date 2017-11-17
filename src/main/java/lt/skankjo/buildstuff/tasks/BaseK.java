package lt.skankjo.buildstuff.tasks;

import java.util.*;
import java.util.stream.IntStream;

public class BaseK {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String arrTemp[] = in.nextLine().split("\\s+");
        int[] arr = Arrays.stream(arrTemp).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int d = arr[1];

        int max = IntStream.range(2, 90)
                .map(base -> baseK(n, base, d))
                .reduce((a, b) -> Math.max(a, b))
                .getAsInt();

        System.out.println(max);
    }

    private static int baseK(int n, int base, int d) {
        int a;
        int count = 0;
        while (n > 0) {
            a = n % base;
            if (a != d) break;
            count++;
            n /= base;
        }
        return count;
    }
}
