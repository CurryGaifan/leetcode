package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanfeixiang on 2016/9/14.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;
        List<Integer> list = new ArrayList();
        list.add(1);
        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;

        int multi_2 = 2 * list.get(index_2);
        int multi_3 = 3 * list.get(index_3);
        int multi_5 = 5 * list.get(index_5);

        for (int i = 1; i < n; i++) {
            int min = Math.min(multi_2, Math.min(multi_3, multi_5));
            list.add(min);
            if (multi_2 == min){
                index_2++;
                multi_2 = 2 * list.get(index_2);
            }

            if (multi_3 == min){
                index_3++;
                multi_3 = 3 * list.get(index_3);
            }

            if (multi_5 == min){
                index_5++;
                multi_5 = 5 * list.get(index_5);
            }

        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(100));
    }
}
