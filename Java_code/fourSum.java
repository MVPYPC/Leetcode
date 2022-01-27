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
                        case 0 -> {
                            do {
                                c++;
                            }
                            while (nums[c] == nums[c - 1] && c < nums.length - 1);
                            do {
                                d--;
                            }
                            while (nums[d] == nums[d + 1] && d > 0);
                        }
                        case -1 -> {
                            do {
                                c++;
                            }
                            while (nums[c] == nums[c - 1] && c < nums.length - 1);
                        }
                        case 1 -> {
                            do {
                                d--;
                            }
                            while (nums[d] == nums[d + 1] && d > 0);
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
        } else if (nums[a] + nums[b] + nums[c] + nums[d] > target)
            return 1;
        else return -1;
    }

    public List<List<Integer>> try_official(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        quickprint.print(new fourSum().find(new int[]{2,2,2,2,2}, 8));
    }
}
