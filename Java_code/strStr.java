package Leetcode.Java_code;

/***************************************************
 * @question
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。

 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 * @tips
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 */

public class strStr {
    public int find(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        for(int i = 0; i + needle.length() <= haystack.length(); i++)
            if(haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        return -1;
    }

    public int E1Zgaymu(String haystack, String needle){
        return haystack.indexOf(needle);
    }

    public static void main(String[] args){
        quickprint.println(new strStr().find("hhyua", "a"));
    }
}
