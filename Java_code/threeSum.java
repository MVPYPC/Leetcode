package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***************************************************
 * @question
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * @tips
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 */

public class threeSum {
    public List<List<Integer>> find(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        for(int first = 0; first < nums.length; first++){
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for(int second = first + 1; second < nums.length; second++){
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = nums.length - 1;
                while(nums[first] + nums[second] + nums[third] > 0 && second != third)
                    third--;
                if(second != third && nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        quickprint.print(new threeSum().find(new int[]{-1,0,1,2,-1,-4}));
    }
}
