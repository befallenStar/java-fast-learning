/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (38.29%)
 * Total Accepted:    25.4K
 * Total Submissions: 66.4K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "race a car"
 * 输出: false
 * 
 * 
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < s.length() - 1)
                i++;
            while (!Character.isLetterOrDigit(s.charAt(j)) && j >= 1)
                j--;
            if (!Character.isLetterOrDigit(s.charAt(i)) && !Character.isLetterOrDigit(s.charAt(j)))
                return true;
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
