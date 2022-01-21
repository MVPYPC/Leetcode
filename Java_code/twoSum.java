package Leetcode;

/***************************************************
 * @question
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * @tips
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * @extension
 * 进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
 */

public class twoSum {
    int[] nums;  //整数数组
    int target;  //整数目标值

    twoSum(int[] nums, int target){
        this.nums = nums;
        this.target = target;
    }

    /************************************************
     * @description
     * 初代版本，暴力遍历求和
     *
     * @time 1ms
     *
     * @memory 38.3MB
     *
     * @Version 1.0
     *
     * @param nums 整数数组
     *
     * @param target 整数目标值
     *
     * @return
     * 整数数组，含有两个整数，分别为找到的两个数的下标
     */
    public int[] Sum_v1(int[] nums, int target) {
        int[] rt = new int[2];
        int flag = -1;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    System.out.println("["+ nums[i] + "," + nums[j] + "]");
                    rt[0] = i;
                    rt[1] = j;
                    flag = 1;
                    break;
                }
            }
        }
        if(flag == -1)
            return null;
        return rt;
    }

    /****
     * @test1
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     * @test2
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     *
     * @test3
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     */
    public static void main(String[] args){
        twoSum test = new twoSum(new int[]{2, 7, 11, 15},9);
        if(test.Sum_v1(test.nums, test.target) == null)
            System.out.println("No result!");
    }
}