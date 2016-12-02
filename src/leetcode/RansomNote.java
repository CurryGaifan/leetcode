package leetcode;

import java.util.Arrays;

/**
 * Created by yanfeixiang on 2016/9/21.
 *  Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,
 * write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.
 * <p/>
 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
 * <p/>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p/>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] r_a = ransomNote.toCharArray();
        char[] m_a = magazine.toCharArray();
        Arrays.sort(r_a);
        Arrays.sort(m_a);
        int j = 0;
        for (int i = 0; i < r_a.length; i++) {
            boolean match = false;
            while (!match && j < m_a.length) {
                if (r_a[i] == m_a[j]) {
                    match = true;
                    j++;
                } else if (r_a[i] > m_a[j]) {
                    j++;
                } else {
                    return false;
                }

            }
            if (!match)
                return false;

        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("a", "b"));
        System.out.println(new RansomNote().canConstruct("aa", "ab"));
        System.out.println(new RansomNote().canConstruct("aa", "aab"));
        System.out.println(new RansomNote().canConstruct("", "aab"));
        System.out.println(new RansomNote().canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));

    }
}
