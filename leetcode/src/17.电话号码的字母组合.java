import java.util.*;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (48.00%)
 * Total Accepted:    18.3K
 * Total Submissions: 38K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */
class Solution {
    private char[][] letters = { {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l', },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++)
            q.add(digits.charAt(i) - 48);
        Queue<String> result = new LinkedList<>();
        int d = q.poll();
        for (int i = 0; i < letters[d - 1].length; i++)
            result.offer(String.valueOf(letters[d - 1][i]));
        while (!q.isEmpty()) {
            d = q.poll();
            int n = result.size();
            for (int i = 0; i < n; i++) {
                String o = result.poll();
                for (int j = 0; j < letters[d - 1].length; j++) {
                    StringBuilder sb = new StringBuilder(o);
                    sb.append(letters[d - 1][j]);
                    result.offer(sb.toString());
                }
            }
        }
        return new ArrayList<>(result);
    }
}
