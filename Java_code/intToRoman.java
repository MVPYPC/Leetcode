package Leetcode;

import java.util.HashMap;

/***************************************************
 * @question
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 * @tips
 * 1 <= num <= 3999
 */

public class intToRoman {
    public String convert(int num) {
        final int[] value = new int[]{1, 5, 10, 50, 100, 500, 1000};
        HashMap<Integer, String> table = new HashMap<>();
        intToRoman.init(table);
        StringBuilder result = new StringBuilder("");
        StringBuilder[] res = new StringBuilder[4];
        int i = 0;
        for(; num > 0; i++, num /= 10)
            res[i] = singleConvert(num % 10, i * 2, value, table);
        for(i--; i >= 0; i--)
            result.append(res[i]);
        return result.toString();
    }

    public static void init(HashMap<Integer, String> table) {
        table.put(1, "I");
        table.put(5, "V");
        table.put(10, "X");
        table.put(50, "L");
        table.put(100, "C");
        table.put(500, "D");
        table.put(1000, "M");
    }

    public StringBuilder singleConvert(int num, int w, int[] value, HashMap<Integer, String> table) {
        StringBuilder sing_res = new StringBuilder();
        switch (num) {
            case 4 -> {
                sing_res.append(table.get(value[w]));
                sing_res.append(table.get(value[w + 1]));
            }
            case 9 -> {
                sing_res.append(table.get(value[w]));
                sing_res.append(table.get(value[w + 2]));
            }
            default -> {
                if (num >= 5) {
                    sing_res.append(table.get(value[w + 1]));
                    num -= 5;
                }
                while (num-- != 0)
                    sing_res.append(table.get(value[w]));
            }
        }
        return sing_res;
    }

    public String official_solution(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

    public static void main(String[] args){
        quickprint.print(new intToRoman().convert(1994));
    }
}
