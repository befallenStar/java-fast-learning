/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (46.06%)
 * Total Accepted:    6.9K
 * Total Submissions: 15K
 * Testcase Example:  '"hello"'
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1:
 * 
 * 输入: "hello"
 * 输出: "holle"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 
 * 说明:
 * 元音字母不包含字母"y"。
 * 
 */
class Solution {
    public String reverseVowels(String s) {
        int[] index = new int[s.length()];
        int cnt = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++)
            if (find(s, i)) {
                index[cnt] = i;
                cnt++;
            }
        for (int i = 0, j = cnt - 1; i < j; i++, j--) {
            char c = s.charAt(index[i]);
            sb.setCharAt(index[i], s.charAt(index[j]));
            sb.setCharAt(index[j], c);
        }
        return sb.toString();
    }

    public boolean find(String s, int i) {
        return s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
                || s.charAt(i) == 'O' || s.charAt(i) == 'U';
    }
}
