package Leetcode.Java_code;

/***************************************************
 * @question
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @tips
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 *
 */

public class removeElement {
    public int remove(int[] nums, int val) {
        int len = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                delete(nums, i);
                nums[nums.length - 1] = 0;
                len--;
                i--;
            }
        }
        return len;
    }
    public void delete(int[] nums, int j){
        if (nums.length - 1 - j >= 0) System.arraycopy(nums, j + 1, nums, j, nums.length - 1 - j);
    }

    public static void main(String[] args){
        int[] test = new int[]{3,2,2,3};
        int length = new removeElement().remove(test, 3);
        quickprint.println(length);
        for(int i = 0; i < length; i++)
            quickprint.print(test[i]);
    }
}
