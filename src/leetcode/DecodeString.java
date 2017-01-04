package leetcode;

public class DecodeString {

    public String decodeString(String s) {

        return decodeString(s, 0).left;
    }

    public Pair decodeString(String s, int startIndex) {

        String str = "";

        int i = 0;

        int times = 0;

        while (true) {

            if (i == s.length())
                break;

            char c = s.charAt(i);
            if (c == '[' && startIndex < i) {
                times = Integer.valueOf(s.substring(startIndex, i));
                startIndex = i + 1;
            }

            if (c == ']' && startIndex < i) {
                String subStr = s.substring(startIndex, i);

                for (int j = 0; j < times; j++) {
                    str += subStr;
                }
                times = 0;
                startIndex = i + 1;
            }

            if (c >= '0' && c <= '9' && times != 0) {
                Pair pair = decodeString(s, i);
                str += pair.left;
                i = pair.right;

            }

            i++;

        }
        return new Pair(str, i);
    }

    static class Pair {

        public Pair(String left, int right) {
            this.left = left;
            this.right = right;
        }

        String left;
        int right;
    }


    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
    }


}
