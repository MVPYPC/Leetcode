package Leetcode;

/***************************************************
 * @question
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * @tips
 * -2^31 <= x <= 2^31 - 1
 *
 * @extension
 * 你能不将整数转为字符串来解决这个问题吗？
 */

public class isPalindrome {
    public static boolean stringreverse(int x){
        if(x < 0) return false;
        StringBuilder s = new StringBuilder(String.valueOf(x));
        String sre = String.valueOf(s.reverse());
        String sself = s.reverse().toString();
        return (sself.toString().equals(sre));
    }

    public static boolean extension(int x){
        if(x < 0) return false;
        int rev = 0;
        int init = x;
        for(;x != 0; x/= 10)
            rev = rev * 10 + x % 10;
        try{
            return init == rev;
        }catch(Exception e){
            return false;
        }

    }
    public static void main(String[] args){
        System.out.println(extension(121));
    }
}
