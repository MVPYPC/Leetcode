package Leetcode.Java_code;

/***************************************************
 * @question
 * 给定两个大小分别为m和n的正序（从小到大）数组nums1和nums2。请你找出并返回这两个正序数组的中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @tips
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */

public class findMedianSortedArrays {

    public  static double find(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        return ((getKth(nums1, 0, m - 1,
                        nums2, 0, n - 1, (m + n + 1) / 2) +
                 getKth(nums1, 0, m - 1,
                        nums2, 0, n - 1, (m + n + 2) / 2)) / (double)2);
    }

    /************************************************
     * @description
     * 参考了题解，使用类似归并排序的递归过程找出第k小的数（getKth），同时用了一个小技巧：找到（m+n+1）/2
     * 和（m+n+2）/2 并加起来除以2，用这个技巧可以规避奇偶数问题。
     *
     *
     * @time 2ms 91.22%
     *
     * @memory 39.8 MB 15.82%
     *
     * @Version 1.0
     *
     * @param nums1 按升序排序的数组1
     * @param start1 数组1的首个元素下标
     * @param end1 数组1的末尾元素下标
     * @param nums2 按升序排序的数组2
     * @param start2 数组2的首个元素下标
     * @param end2 数组2的末尾元素下标
     * @param k 要找第k个数
     *
     * @return
     * 找到的第k小数
     */
    public static int getKth(int[] nums1, int start1, int end1,
                             int[] nums2, int start2, int end2, int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j])
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        else
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
    }

    /****
     * @test1
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     *
     * @test2
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     *
     * @test3
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     *
     * @test4
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     *
     * @test5
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     */
    public static void main(String[] args){
        System.out.println(find(new int[]{1,2}, new int[]{3,4}));
    }
}
