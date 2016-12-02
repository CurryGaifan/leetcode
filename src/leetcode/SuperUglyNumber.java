package leetcode;

import java.util.*;

/**
 * Created by yanfeixiang on 2016/9/14.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1)
            return 1;
        List<Integer> list = new ArrayList();
        list.add(1);
        Queue<Struct> queue = new PriorityQueue(primes.length, new Comparator<Struct>() {
            @Override
            public int compare(Struct o1, Struct o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });
        for (int prime : primes) {
            queue.add(new Struct(prime, prime, 1));
        }

        while (list.size()!=n) {
            Struct struct = queue.poll();


            if (struct.value != list.get(list.size() - 1)) {
                list.add(struct.value);
            }

            queue.add(new Struct(struct.prime, list.get(struct.index) * struct.prime, struct.index + 1));
        }
        return list.get(list.size() - 1);
    }

    private static class Struct {
        int prime;
        int value;
        int index;

        public Struct(int prime, int value, int index) {
            this.prime = prime;
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SuperUglyNumber().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
