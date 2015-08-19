package leetcode;

/**
 *
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int j = Math.max(A, E);
        int k = Math.max(B, F);
        int m = Math.min(C, G);
        int n = Math.min(D, H);

        int join = 0;

        if (C <= E || G <= A || D <= F || H <= B) {

        } else {
            join = Math.max(0, (m - j)) * Math.max(0, (n - k));
        }

        return (C - A) * (D - B) + (G - E) * (H - F) - join;
    }

    public static void main(String[] args) {
        System.out.println(new RectangleArea().computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
    }
}
