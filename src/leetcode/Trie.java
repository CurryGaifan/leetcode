package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TrieNode {


    // Initialize your data structure here.
    String str;
    List<TrieNode> list;

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    boolean end;

    public TrieNode(String str) {
        this.str = str;
        this.list = new ArrayList<TrieNode>();
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode("");
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode last = root;
        TrieNode tn = find(last, word);
        while (tn != null) {
            word = word.substring(tn.str.length());
            last = tn;
            tn = find(tn, word);

        }

        if (word.length() == 0) {
            last.end = true;
        } else {
            boolean findss = false;
            for (int i = 0; i < last.list.size(); i++) {
                TrieNode cur = last.list.get(i);
                if (word.charAt(0) == cur.str.charAt(0)) {
//                    System.out.println("word: " + word + ", cur: " + cur.str);

                    findss = true;
                    int index = findIndex(word, cur.str);
//                    System.out.println("index: " + index);
                    if (index == word.length()) {
                        last.list.remove(i);
                        TrieNode add = new TrieNode(word);
                        add.end = true;
                        last.list.add(add);
                        add.list.add(cur);
                        cur.str = cur.str.substring(index);


                    } else if (index == cur.str.length()) {
                        TrieNode add = new TrieNode(word.substring(index));
                        add.end = true;
                        cur.list.add(add);

                    } else {
                        last.list.remove(i);
                        TrieNode add = new TrieNode(word.substring(0, index));
                        add.list.add(cur);
                        last.list.add(add);
                        cur.str = cur.str.substring(index);


                        TrieNode add1 = new TrieNode(word.substring(index));
                        add1.end = true;
                        add.list.add(add1);
                    }


                }
            }
            if (!findss) {
                TrieNode add = new TrieNode(word);
                add.end = true;
                last.list.add(add);
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode last = root;
        TrieNode tn = find(last, word);
        while (tn != null) {
            word = word.substring(tn.str.length());
            last = tn;
            tn = find(tn, word);

        }

        if (word.length() == 0 && last.end)
            return true;
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode last = root;
        TrieNode tn = find(last, prefix);
        while (tn != null) {
            prefix = prefix.substring(tn.str.length());
            last = tn;
            tn = find(tn, prefix);

        }
//        System.out.println("prefix:" + prefix + ", last.str :" + last.str);
        if (prefix.length() == 0 && last.end)
            return true;

        for (TrieNode cur : last.list) {
            if (cur.str.startsWith(prefix))
                return true;

        }

        return false;
    }

    private TrieNode find(TrieNode tn, String str) {
        for (TrieNode cur : tn.list) {
            if (str.startsWith(cur.str))
                return cur;
        }
        return null;
    }

    public static void main(String[] args) {
//         Your Trie object will be instantiated and called as such:
        Trie trie = new Trie();
        trie.insert("abc");
        System.out.println(trie.startsWith("a"));
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ab"));
        trie.insert("ab");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ab"));

        trie.insert("ad");
        System.out.println(trie.search("abc"));
        System.out.println(trie.search("ab"));
        System.out.println(trie.search("ad"));


    }

}



