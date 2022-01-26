package Leetcode.Java_code;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***************************************************
 * @question
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * @tips
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 */

public class fourSum {
    public List<List<Integer>> find(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            for (int b = a + 1; b < nums.length - 1; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                int c = b + 1, d = nums.length - 1;
                while (c < d)
                    switch (Check_inList(result, nums, a, b, c, d, target)) {
                        case 0 -> d--;
                        case -1 -> {
                            do {
                                c++;
                            }
                            while (nums[c] == nums[c - 1]);
                        }
                        case 1 -> {
                            do {
                                d--;
                            }
                            while (nums[d] == nums[d + 1]);
                        }
                    }
            }
        }
        return result;
    }

    public int Check_inList(List<List<Integer>> result, int[] nums, int a, int b, int c, int d, int target) {
        if (nums[a] + nums[b] + nums[c] + nums[d] == target) {
            List<Integer> single = new ArrayList<Integer>() {{
                add(nums[a]);
                add(nums[b]);
                add(nums[c]);
                add(nums[d]);
            }};
            result.add(single);
            return 0;
        } else if (a + b + c + d > target)
            return 1;
        else return -1;
    }

    public static void main(String[] args) {
        quickprint.print(new fourSum().find(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
