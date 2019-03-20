/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (35.40%)
 * Total Accepted:    13.3K
 * Total Submissions: 37.5K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        if (nums.length == 1 && nums[0] == target) {
            first = 0;
            last = 0;
        }
        int left = 0, right = nums.length - 1;
        int mid = (left + right) >> 1;
        while (left <= right) {
            if (nums[mid] == target) {
                while (mid >= 0) {
                    if (nums[mid] == target) {
                        first = mid;
                        mid--;
                    } else
                        break;
                }
                mid = (left + right) >> 1;
                while (mid < nums.length) {
                    if (nums[mid] == target) {
                        last = mid;
                        mid++;
                    } else
                        break;
                }
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
                mid = (left + right) >> 1;
            } else {
                right = mid - 1;
                mid = (left + right) >> 1;
            }
        }
        int[] result = { first, last };
        return result;
    }
}
