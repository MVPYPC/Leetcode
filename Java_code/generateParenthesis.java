package Leetcode.Java_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***************************************************
 * @question
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 小括号组合。
 *
 * @tips
 * 1 <= n <= 8
 */

public class generateParenthesis {
    public List<String> generate_dp(int n) {
        List<List<String>> record = new ArrayList<>();
        //dp 边界条件
        record.add(Collections.singletonList(""));  //n = 0
        record.add(Collections.singletonList("()")); // n = 1
        //dp start
        for(int i  = 2; i <= n; i++){      //for record
            List<String> temp = new ArrayList<>();
            for(int j = 0; j < i; j++){  //for record[i]
                List<String> str1 = record.get(j);
                List<String> str2 = record.get(i - 1 - j);
                for(String s1 : str1)
                    for(String s2 : str2){
                        String str = "(" + s1 + ")" + s2;//状态转移方程
                        temp.add(str);
                    }
            }
            record.add(temp);
        }
        return record.get(n);
    }


    public static void main(String[] args){
        quickprint.print(new generateParenthesis().generate_dp(8));
    }
}
