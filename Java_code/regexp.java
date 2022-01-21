package Leetcode.Java_code;

/***************************************************
 * @question
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 *
 *
 * @tips
 * 1 <= s.length<= 20
 * 1 <= p.length<= 30
 * s 只含小写英文字母。
 * p只含小写英文字母，以及字符.和*。
 * 保证每次出现字符* 时，前面都匹配到有效的字符
 *
 */

public class regexp {
    /************************************************
     * @description
     * 参考了题解，运用动态规划思想从头到尾遍历，这里找状态转移方程感觉有难度，具体代码实现较简单，
     * 需要注意的是一开始贪便宜只想遍历一遍p，j按阶梯状下滑，但是最后发现应该更新整张表（即每次j都从0开始）
     *
     * @time 5ms 28.53%
     *
     * @memory 36.9 MB 61.23%
     *
     * @Version 1.0
     *
     * @param s s字符串
     * @param p p字符串
     *
     * @return 是否匹配
     */
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < p.length(); j++)
                switch (p.charAt(j)) {
                    case '.' -> dp[i + 1][j + 1] = dp[i][j];

                    case '*' -> {
                        dp[0][j + 1] = dp[0][j - 1];
                        if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1] //*匹配0次
                                            || dp[i][j + 1];            //匹配 >= 1次
                        } else
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }

                    default ->   //'a'~'z'
                            dp[i + 1][j + 1] = s.charAt(i) == p.charAt(j) && dp[i][j];
                }

        return dp[s.length()][p.length()];

    }


    /****
     * @test1
     * 输入：s = "aa" p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     *
     * @test2
     * 输入：s = "aa" p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     *
     *
     * @test3
     * 输入：s = "ab" p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     *
     * @test4
     * 输入：s = "aab" p = "c*a*b"
     * 输出：true
     * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     *
     * @test5
     * 输入：s = "mississippi" p = "mis*is*p*."
     * 输出：false
     *
     * @test6
     * 输入：s = "aaa" p = "ab*a*c*a"
     * 输出：true
     */
    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "ab*a*c*a"));
    }
}
