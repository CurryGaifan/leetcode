package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 */
public class AddandSearchWordDatastructuredesign {
    // Adds a word into the data structure.
    Trie1 t = new Trie1();

    public void addWord(String word) {
        t.insert(word);
//        System.out.println(t.root);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return t.search(word);
    }


    //addWord("a"),addWord("a"),search("."),search("a"),search("aa"),search("a"),search(".a"),search("a.")
    public static void main(String[] args) {
        AddandSearchWordDatastructuredesign a = new AddandSearchWordDatastructuredesign();

        System.out.println(a.search("."));
        System.out.println(a.search("a"));
        System.out.println(a.search("aa"));

        System.out.println(a.search("a"));
        System.out.println(a.search("a."));
        System.out.println(a.search(".a"));

    }

}

class TrieNode1 {


    // Initialize your data structure here.
    String str;
    TrieNode1[] array = new TrieNode1[26];

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    boolean end;

    public TrieNode1(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public TrieNode1[] getArray() {
        return array;
    }

    public void setArray(TrieNode1[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "TrieNode1{" +
                "str='" + str + '\'' +
                ", array=" + Arrays.toString(array) +
                ", end=" + end +
                '}';
    }
}

class Trie1 {
    public TrieNode1 root;

    public Trie1() {
        root = new TrieNode1("");
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode1 last = root;
        TrieNode1 tn = find(last, word);
        while (tn != null) {
//            System.out.println("word: " + word + ", tn.str: " + tn.str);
            word = word.substring(tn.str.length());
            last = tn;
            tn = find(tn, word);

        }

        if (word.length() == 0) {
            last.end = true;
        } else {
            boolean findss = false;
            int i = word.charAt(0) - 'a';

            TrieNode1 cur = last.array[i];
            if (null != cur && word.charAt(0) == cur.str.charAt(0)) {

                findss = true;
                int index = findIndex(word, cur.str);
                if (index == word.length()) {
                    last.array[i] = null;
                    TrieNode1 add = new TrieNode1(word);
                    add.end = true;
                    last.array[add.str.charAt(0) - 'a'] = add;
                    add.array[cur.str.charAt(0) - 'a'] = cur;

                    cur.str = cur.str.substring(index);


                } else if (index == cur.str.length()) {
                    TrieNode1 add = new TrieNode1(word.substring(index));
                    add.end = true;
                    cur.array[add.str.charAt(0) - 'a'] = add;

                } else {
                    last.array[i] = null;
                    TrieNode1 add = new TrieNode1(word.substring(0, index));
                    add.array[cur.str.charAt(0) - 'a'] = cur;
                    last.array[add.str.charAt(0) - 'a'] = add;
                    cur.str = cur.str.substring(index);


                    TrieNode1 add1 = new TrieNode1(word.substring(index));
                    add1.end = true;
                    add.array[add1.str.charAt(0) - 'a'] = add1;
                }

            }
            if (!findss) {
                TrieNode1 add = new TrieNode1(word);
                add.end = true;
                last.array[add.str.charAt(0) - 'a'] = add;
            }


        }


    }

    private int findIndex(String word, String str) {
        int i = 0;
        for (; i < word.length() && i < str.length(); i++) {
            if (word.charAt(i) != str.charAt(i))
                return i;
        }
        return i;

    }


    private TrieNode1 find(TrieNode1 tn, String str) {
//        System.out.println("tn: " + tn);
//        System.out.println("str: " + str);
        if (str.length() == 0)
            return null;
        TrieNode1 subTn = tn.array[str.charAt(0) - 'a'];
        if (null != subTn && null != subTn.str && str.startsWith(subTn.str))
            return subTn;
        else
            return null;

    }

    public boolean search(String str) {
        return search(root, str);
    }


    private static boolean search(TrieNode1 tn, String str) {
        if (null == tn || !startWithMatch(tn.str, str))
            return false;
        else {
            str = str.substring(tn.str.length());
            if (str.length() == 0 && tn.isEnd())
                return true;
            if (str.length() == 0)
                return false;

            char c = str.charAt(0);
            if (c == '.')
                for (TrieNode1 cur : tn.array) {
                    if (search(cur, str))
                        return true;
                }
            else if (search(tn.array[str.charAt(0) - 'a'], str))
                return true;

        }
        return false;

    }

    private static boolean startWithMatch(String a, String b) {
        if (a.length() > b.length())
            return false;

        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) == '.')
                continue;
            else if (b.charAt(i) == a.charAt(i))
                continue;
            else return false;
        }
        return true;

    }
    
}