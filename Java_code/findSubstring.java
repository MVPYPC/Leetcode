package Leetcode.Java_code;

import java.util.ArrayList;
import java.util.List;

/***************************************************
 * @question
 *给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *
 * @tips
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 由小写英文字母组成
 */

public class findSubstring {
    public List<Integer> find(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(!s.contains(words[i]))
                break;
            
        }
        return result;
    }
}
