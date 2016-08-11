package leetcode;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p/>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        for (int i = 0; start + i < end - i; i++) {
            char tmp = chars[start + i];
            chars[start + i] = chars[end - i];
            chars[end - i] = tmp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString("hello"));
    }
}
