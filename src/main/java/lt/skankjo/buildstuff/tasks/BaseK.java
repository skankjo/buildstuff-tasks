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
                .map(base -> countWhileEquals(baseK(n, base), d))
                .reduce((a, b) -> Math.max(a, b))
                .getAsInt();

        System.out.print(max);
    }

    private static List<Integer> baseK(int n, int base) {
        List<Integer> result = new ArrayList<>();
        int a;
        while (n > 0) {
            a = n % base;
            result.add(a);
            n /= base;
        }
        return result;
    }

    private static int countWhileEquals(List<Integer> seq, int d) {
        int count = 0;
        Iterator<Integer> it = seq.iterator();
        while (it.hasNext() && it.next() == d) count++;
        return count;
    }
}
