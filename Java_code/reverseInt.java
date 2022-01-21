package Leetcode;

/***************************************************
 * @question
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * @tips
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */

public class reverseInt {

    public static int reverse(int x) {
        StringBuilder num = new StringBuilder(String.valueOf(Math.abs(x)));
        num.reverse();
        try {
            return (x > 0 ? 1 : -1) * Integer.valueOf(num.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
