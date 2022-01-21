package Leetcode;

import java.util.HashMap;
import java.util.Map;

/***************************************************
 * @question
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2^31, 2^31− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31
 * ，大于 2^31− 1 的整数应该被固定为 2^31− 1 。
 * 返回整数作为最终结果。
 *
 * @tips
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 */

public class myAtoi {
    /************************************************
     * @description
     * 独立完成，但是代码十分屎山，光看题目感觉非常简单，但是实际代码实现非常shit，代码时间空间复杂度也不好，非常拉。
     *
     * @time 3ms 29.47%
     *
     * @memory 38.5 MB 25.17%
     *
     * @Version 1.0
     *
     * @param s 待检测字符串
     *
     * @return
     * 按照题给规则返回int值
     */
    public static int Atoi(String s) {
        //第一层屎山，处理只有一个数字字符情况
        if(s.length() == 1 && Character.isDigit(s.charAt(0)))
            return s.charAt(0) - '0';


        int i = 0;
        int flag = 0;
        StringBuilder num = new StringBuilder("");
        //过滤空格
        try {
            while (s.charAt(i) == ' ')
                i++;
        }catch(Exception e){
            return 0;
        }

        //Big 屎山
        if(i >= s.length() - 1)//处理全是空格情况
            return 0;
        else if(s.charAt(i) == '-'){//读到'-'
            flag = -1;
            if(i + 1 >= s.length() || !Character.isDigit(s.charAt(++i))) //读到末尾 或 不是数字
                return 0;
        }else if(s.charAt(i) == '+') {
            flag = 1;
            if(i + 1 >= s.length() || !Character.isDigit(s.charAt(++i)))
                return 0;
        } else if(i + 1 >= s.length() || !Character.isDigit(s.charAt(i)))
            return 0;
        else
            flag = 1;
        while( i < s.length() && Character.isDigit(s.charAt(i)))
            num.append(s.charAt(i++));
        try{
            int value = Integer.parseInt(num.toString());
            return flag * value;
        }catch (Exception e){
            if(flag > 0)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
    }


    public static void main(String[] args){
        //System.out.println(Atoi("1"));
        System.out.println(new AutoFSM().Doit("  -42555595987623215487546"));
    }
}

/************************************************
 * @description
 * 参考官方题解，使用有限状态机思想求解，但是我写的版本理论上应该遍历较少次数，但是跑出来效率甚至比第一版拉，emmm很离谱，可能是字符串转int效率较低，
 * 我觉得我写的版本比较适用于检测字符串较长的情况。
 * @time 4ms 16%
 *
 * @memory 38.6 MB 12%
 *
 * @Version 1.0
 *
 */
class AutoFSM{
    public int flag = 1;
    private String status = "start";
    public StringBuffer ans= new StringBuffer("");
    Map<String, String[]> table = new HashMap<String, String[]>(){
        {
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }
    };
    public int Doit(String s){
        AutoFSM check = new AutoFSM();
        for(int i = 0; i < s.length() && !check.status.equals("end"); i++)
            check.get(s.charAt(i));
        try{
            if(check.ans.toString().isEmpty())
                return 0;
            return check.flag * Integer.parseInt(check.ans.toString());
        }catch (Exception e){
            if(check.flag > 0)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
    }

    public void get(char c){
        status = table.get(status)[get_next(c)];
        switch (status) {
            case "in_number" -> ans.append(c);
            case "signed" -> flag = c == '+' ? 1 : -1;
        }
    }

    private int get_next(char c){
        if(c == ' ') return 0;
        else if(c == '+' || c == '-') return 1;
        else if(Character.isDigit(c)) return 2;
        else return 3;
    }
}