/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 *
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/description/
 *
 * algorithms
 * Medium (60.58%)
 * Total Accepted:    1.9K
 * Total Submissions: 3.1K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 
 * 
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 * 
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1)
            return nums[1];
        int left = 0, right = nums.length - 1;
        int mid = (left + right) >> 1;
        while (left <= right - 2) {
            if (nums[left] == nums[mid])
                return nums[right];
            if (nums[mid] == nums[right])
                return nums[left];
            if (nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 1)
                    right=mid;
                else
                    left=mid;
            } else if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 1)
                    left=mid;
                else
                    right=mid;
            } else {
                return nums[mid];
            }
            mid = (left + right) >> 1;
        }
        return nums[mid];
    }
}
