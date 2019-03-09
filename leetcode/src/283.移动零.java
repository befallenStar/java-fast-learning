/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (52.78%)
 * Total Accepted:    35.6K
 * Total Submissions: 67.4K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0) {
                nums[cnt] = nums[i];
                cnt++;
            }
        for (; cnt < nums.length; cnt++)
            nums[cnt] = 0;
    }
}