package Leetcode.Java_code;

import javax.swing.*;
import java.util.*;

/***************************************************
 * @question
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 1:0_0    2:abc   3:def
 * 4:ghi    5:jkl   6:mno
 * 7:pqrs   8:tuv   9:wxyz
 *
 *
 * @tips
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 */

public class letterCombinations {
    HashMap<Character, String> table = new HashMap<>();

    public List<String> backtrack(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        init(table);
        back(result, digits, 0, new StringBuilder());
        return result;
    }

    public static void init(HashMap<Character, String> table) {
        table.put('2', "abc");
        table.put('3', "def");
        table.put('4', "ghi");
        table.put('5', "jkl");
        table.put('6', "mno");
        table.put('7', "pqrs");
        table.put('8', "tuv");
        table.put('9', "wxyz");
    }

    public void back(List<String> result, String digits, int cur, StringBuilder temp) {
        if (cur == digits.length())//遍历至数字字符串尾，可以添加至result
            result.add(temp.toString());
        else
            for (int i = 0; i < table.get(digits.charAt(cur)).length(); i++) {
                temp.append(table.get(digits.charAt(cur)).charAt(i));//添加第一个
                back(result, digits, cur + 1, temp);//递归下一个字符
                temp.deleteCharAt(cur);//回溯操作，删去现在指向的字符
            }
    }

    public List<String> queueSolution(String digits) {
        List<String> result = new ArrayList<>();
        Queue<String> process = new LinkedList<>();
        if (digits.length() == 0) return result;
        init(table);
        queue_combine(process, digits);
        for (String s : process)
            result.add(s);
        return result;
    }

    public void queue_combine(Queue<String> process, String digits) {
        for (int i = 0; i < digits.length(); i++) {
            if (i == 0)//空队列处理
                for (int j = 0; j < table.get(digits.charAt(i)).length(); j++)
                    process.add(String.valueOf(table.get(digits.charAt(i)).charAt(j)));
            else
                for (int j = 0, num = process.size(); j < num; j++) {
                    String pop = process.poll();
                    for (int k = 0; k < table.get(digits.charAt(i)).length(); k++)
                        process.add(pop + String.valueOf(table.get(digits.charAt(i)).charAt(k)));
                }
        }
    }

    public static void main(String[] args) {
        quickprint.print(new letterCombinations().queueSolution("23"));
    }
}
