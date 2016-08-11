package leetcode;

/**
 * Created by yanfeixiang on 2016/8/3.
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int num) {

        //0x55555555 二进制表示0101......0101
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

}
