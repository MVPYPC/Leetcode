package Leetcode.Java_code;

/***************************************************
 * @question
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * @tips
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 */

public class maxArea {
    public int getMax(int[] height){
        int max = 0;
        for(int left = 0; left < height.length; left++){
            for(int right = left + 1; right < height.length; right++)
                max = Math.max(max, (right - left) * (Math.min(height[left], height[right])));
        }
        return max;
    }

    public int get(int[] height){
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if(height[left] > height[right])
                do {
                    right--;
                } while(height[right] <= height[right + 1] && right > left);
            else
                do{
                    left++;
                } while(height[left] <= height[left - 1] && right > left);
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(new maxArea().get(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
