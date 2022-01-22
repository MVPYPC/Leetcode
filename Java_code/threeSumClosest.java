package Leetcode.Java_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***************************************************
 * @question
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *
 * @tips
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 *
 */

public class threeSumClosest {
    public int find(int[] nums, int target) {
        int result = 100000;
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                for (int third = nums.length - 1; third > second; third--) {
                    result = Math.abs(target - (nums[first] + nums[second] + nums[third])) < Math.abs(result - target) ?
                            nums[first] + nums[second] + nums[third] : result;
                    if (Math.abs(target - (nums[first] + nums[second] + nums[third])) == 0)
                        return target;
                }

            }
        }
        return result;
    }

    public int on2find(int[] nums, int target) {
        int result = 100000;
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1, third = nums.length - 1;
            while (second < third) {
                if (nums[first] + nums[second] + nums[third] == target)
                    return target;
                result = Math.abs(target - (nums[first] + nums[second] + nums[third])) < Math.abs(result - target) ?
                        nums[first] + nums[second] + nums[third] : result;
                if (nums[first] + nums[second] + nums[third] > target)
                    do {
                        third--;
                    }while (third - 1 > second && nums[third + 1] == nums[third]);

                else
                    do {
                        second++;
                    }while(second + 1 < third && nums[second + 1] == nums[second]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        quickprint.print(new threeSumClosest().on2find(new int[]{3,4,5,5,7}, 13));
    }
}
