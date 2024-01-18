package Leetcode.Java_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***************************************************
 * @question
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 *
 *  s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 *
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 *
 * @tips
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 由小写英文字母组成
 */
public class findSubstring_Concatenates {
    public List<Integer> Solution(String s, String[] words) {
        int s_len = s.length(), num = words.length, len = words[0].length();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < len; i++){
            if(i + num * len > s_len)
                break;
            //初始化窗口
            Map<String, Integer> differ = new HashMap<>();
            for(int j = 0; j < num; j++){
                String word = s.substring(i + j * len, i + (j + 1) * len);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            //遍历当前窗口内的所有单词
            for(String word : words){
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if(differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            if(differ.isEmpty()){
                ans.add(i);
            }
            //开始滑动
            for(int start = i; start <= s_len - (num + 1) * len; start += len){
                //右边的单词滑进窗口
                String word = s.substring(start + num * len, start + (num + 1) * len);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
                if(differ.get(word) == 0) {
                    differ.remove(word);
                }

                //左边的单词滑出窗口
                word = s.substring(start, start + len);
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if(differ.get(word) == 0) {
                    differ.remove(word);
                }
                //检验是否匹配
                if(differ.isEmpty()){
                    ans.add(start + len);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        quickprint.print(new findSubstring_Concatenates().Solution(new String("wordgoodgoodgoodbestword"),
                         new String[]{"word","good","best","good"}));
    }
}
