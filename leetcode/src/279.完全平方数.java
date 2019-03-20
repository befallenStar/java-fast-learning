/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 *
 * https://leetcode-cn.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (48.79%)
 * Total Accepted:    6.7K
 * Total Submissions: 13.7K
 * Testcase Example:  '12'
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 
 * 示例 1:
 * 
 * 输入: n = 12
 * 输出: 3 
 * 解释: 12 = 4 + 4 + 4.
 * 
 * 示例 2:
 * 
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * 
 */
class Solution {
	public int numSquares(int n) {
		// dp
		// if(n < 4)
		// return n;
		// int[] tmps = new int[n + 1];
		// for(int i = 0; i < 4; i++)
		// tmps[i] = i;
		// for(int i = 4; i <= n; i++){
		// int tmp = n;
		// for(int j = 2; j * j <= i; j++){
		// tmp = Math.min(tmp, tmps[i - j * j] + 1);
		// }
		// tmps[i] = tmp;
		// }
		// return tmps[n];

		// 四平方和定理：任何一个正整数都可以表示为最多四个平方数之和
		// 只有形如4^a(8b+7)的数才需要用4个平方数表示
		if (n < 4)
			return n;
		if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n)
			return 1;
		int t = n;
		while (t % 4 == 0)
			t /= 4;
		if (t % 8 == 7)
			return 4;
		for (int i = 1; i <= n / 2; i++)
			for (int j = 2; j <= n / 2; j++)
				if (j * j + i * i == n)
					return 2;
		return 3;
	}
}
