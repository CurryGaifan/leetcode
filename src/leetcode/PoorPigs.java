package leetcode;

public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets <= 1)
            return 0;

        int c = minutesToTest / minutesToDie;
        if (c <= 0)
            return -1;
        c++;
//        System.out.println("c: " + c);
        int count = 0;
        int tmp = 1;
        while (tmp < buckets) {
            tmp *= c;
            count++;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new PoorPigs().poorPigs(16, 2, 4));//3
        System.out.println(new PoorPigs().poorPigs(14, 2, 4));//3
        System.out.println(new PoorPigs().poorPigs(30, 2, 4));//4
        System.out.println(new PoorPigs().poorPigs(1000, 15, 60));//5
        System.out.println(new PoorPigs().poorPigs(1000, 12, 60));//4
    }
}
