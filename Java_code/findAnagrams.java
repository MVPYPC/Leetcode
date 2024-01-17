package Leetcode.Java_code;

import java.util.ArrayList;
import java.util.List;

/***************************************************
 * @question
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * @tips
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */

public class findAnagrams {
    public List<Integer> Solution(String s, String p) {
        int slen = s.length(), plen = p.length();//长度
        List<Integer> ans = new ArrayList<>();
        if(slen < plen)
            return  ans;
        //初始化count
        int[] count = new int[26];
        for(int i = 0; i < plen; i++){
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }
        //初始化differ
        int differ = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                differ++;
            }
        }
        //检验第一个位置
        if(differ == 0)
            ans.add(0);

        //开始滑动
        for(int i = 0; i < slen - plen; i++){
            //退第一个
            if(count[s.charAt(i) - 'a'] == 0)
                differ++;
            else if(count[s.charAt(i) - 'a'] == 1)
                differ--;
            count[s.charAt(i) - 'a']--;

            //进最后一个
            if(count[s.charAt(i + plen) - 'a'] == -1)
                differ--;
            else if(count[s.charAt(i + plen) - 'a'] == 0)
                differ++;
            count[s.charAt(i + plen) - 'a']++;

            //判断是否符合
            if(differ == 0)
                ans.add(i + 1);
        }
        return ans;
    }

    public static void main(String[] args){
        quickprint.print(new findAnagrams().Solution(new String("cbaebabacd"),new String("abc")));
    }
}
