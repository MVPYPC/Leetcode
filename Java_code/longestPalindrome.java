package Leetcode.Java_code;

/***************************************************
 * @question
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @tips
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 */

public class longestPalindrome {
    /************************************************
     * @description
     * 参考了题解，运用动态规划思想自底向上求解，注意这里需要从字符串末尾开始往前遍历
     *
     * @time 130ms 52.32%
     *
     * @memory 41.9 MB 41.88%
     *
     * @Version 1.0
     *
     * @param s 待检测字符串
     *
     * @return s的回文子串
     */
    public static String toFind(String s){
        int max= 1;
        int begin = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()]; //动态规划数组
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){      //i,j分别表示检测字符串的起始、末尾下标
                if(j == i ){
                    dp[i][j] = true;
                    continue;
                }else if(j == i + 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    if(max < 2){
                        max = 2;
                        begin = i;
                        end = j;
                    }
                    continue;
                }
                if(dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    if(j - i + 1 > max){
                        begin = i;
                        end = j;
                        max = j - i + 1;
                    }
                }
            }
        }
        return s.substring(begin,end + 1);//这里end要+1，因为打印字符串最后一个字符不打印
    }
    /****
     * @test1
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * @test2
     * 输入：s = "cbbd"
     * 输出："bb"
     *
     * @test3
     * 输入：s = "a"
     * 输出："a"
     *
     * @test4
     * 输入：s = "ac"
     * 输出："a"
     */
    public static void main(String[] args){
        System.out.println(toFind(new String("aaaa")));
    }
}
