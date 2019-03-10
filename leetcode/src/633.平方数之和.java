/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 *
 * https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 *
 * algorithms
 * Easy (29.64%)
 * Total Accepted:    4.2K
 * Total Submissions: 14K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 * 
 * 示例1:
 * 
 * 
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 * 
 * 
 * 
 * 
 * 示例2:
 * 
 * 
 * 输入: 3
 * 输出: False
 * 
 * 
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 0, j = (int) Math.sqrt(c); i <= j;) {
            int r = (int) (Math.pow(i, 2) + Math.pow(j, 2));
            if (r == c)
                return true;
            else if (r < c)
                i++;
            else
                j--;
        }
        return false;
    }
}
