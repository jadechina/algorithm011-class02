/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2020 All Rights Reserved.
 */

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * @author tao.shen
 * @version : IsAnagram, v1.0 2020年07月02日 22:32 tao.shen Exp $
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            arr[index]--;
            if (arr[index] < 0) {
                return false;
            }
        }
        return true;
    }

}
