package Leetcode.Java_code;

import java.util.HashMap;

/***************************************************
 * @question
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * @tips
 * 0 <= nums.length <= 3 * 104
 * -10^4 <= nums[i] <= 10^4
 * nums 已按升序排列
 *
 */

public class removeDuplicates {
    public int remove_vio(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++)
            for(int j = 0; j < i; j++)
                if(nums[i] == nums[j]) {
                    delete(nums, i);
                    len--;
                    i--;
                }
        return len;


    }
    public void delete(int[] nums, int j){
        if (nums.length - 1 - j >= 0) System.arraycopy(nums, j + 1, nums, j, nums.length - 1 - j);
    }
    public int remove_hash(int[] nums){
        HashMap<Integer,Integer> record = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if (record.containsKey(nums[i])) {
                delete(nums, i);
                len--;
                i--;
            }
            else record.put(nums[i], 1);
        }
        return len;
    }
    public int remove_2p(int[] nums){
        if (nums.length == 0) return 0;
        int fast = 1, slow = 1;
        for(; fast < nums.length; fast++)
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
        return slow;
    }

    public static void main(String[] args){
        int[] test = new int[]{1,2,2,2,3,4,5};
        int length = new removeDuplicates().remove_2p(test);
        quickprint.println(length);
        for(int i = 0; i < length; i++)
            System.out.print(test[i]);
    }
}
