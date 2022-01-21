package Leetcode.Java_code;

/***************************************************
 * @question
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * @tips
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */

public class ZtypeConvert {

    /************************************************
     * @description
     * 独立完成，感觉代码写的比较优雅简洁，主要思路是按照s字符串顺序按Z字型遍历，并依次存入对应行字符串中
     * 设置flag指针用于指向当前行号，到底或顶时则偏转。
     *
     * @time 6ms 48%
     *
     * @memory 38.6 MB 78%
     *
     * @Version 1.0
     *
     * @param s 待检测字符串
     * @param numRows Z字型行数
     *
     * @return
     * 转化完成的Z字型字符串
     */
    public static String convert(String s, int numRows){
        if(s.length() <= numRows || numRows == 1)
            return s;
        StringBuilder result = new StringBuilder("");
        StringBuffer[] rows = new StringBuffer[numRows];
        for(int i = 0; i < numRows; i++)
            rows[i] = new StringBuffer("");

        int flag = 0;    //用于标记是否到达上/下界
        int cur = 0;     //用于记录s指针位置
        do {
            for (; flag < numRows && cur < s.length(); flag++, cur++)//下滑
                rows[flag].append(s.charAt(cur));
            for (flag = numRows - 2; flag > 0 && cur < s.length(); flag--, cur++)//上滑
                rows[flag].append((s.charAt(cur)));
        } while (cur != s.length());

        for(int i = 0; i < numRows; i++)
            result.append(rows[i].toString());

        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(new String(convert(new String("PAYPALISHIRING"),
                                                         3)));
    }
}
