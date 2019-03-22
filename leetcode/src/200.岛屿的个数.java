import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿的个数
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (41.57%)
 * Total Accepted:    10K
 * Total Submissions: 24K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */
class Solution {
	public int numIslands(char[][] grid) {
		if (grid.length == 0)
			return 0;
		if (grid.length * grid[0].length == 1)
			if (grid[0][0] == '1')
				return 1;
			else
				return 0;
		Queue<Integer> isle = new LinkedList<>();
		int result = 0;
		int rowLen = grid.length;
		int colLen = grid[0].length;
		boolean[][] visited = new boolean[rowLen][colLen];
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				visited[i][j] = false;
			}
		}
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (grid[i][j] == '1') {
					if (!visited[i][j]) {
						visited[i][j] = true;
						isle.offer(i * colLen + j);
					}
				} else {
					if (!isle.isEmpty())
						result++;
					while (!isle.isEmpty()) {
						int index = isle.poll();
						int indexI = index / colLen;
						int indexJ = index % colLen;
						if (indexI < rowLen - 1) {
							if (!visited[indexI + 1][indexJ]) {
								visited[indexI + 1][indexJ] = true;
								if (grid[indexI + 1][indexJ] == '1')
									isle.offer(index + colLen);
							}
						}
						if (indexI > 0) {
							if (!visited[indexI - 1][indexJ]) {
								visited[indexI - 1][indexJ] = true;
								if (grid[indexI - 1][indexJ] == '1')
									isle.offer(index - colLen);
							}
						}
						if (indexJ < colLen - 1) {
							if (!visited[indexI][indexJ + 1]) {
								visited[indexI][indexJ + 1] = true;
								if (grid[indexI][indexJ + 1] == '1')
									isle.offer(index + 1);
							}
						}
						if (indexJ > 0) {
							if (!visited[indexI][indexJ - 1]) {
								visited[indexI][indexJ - 1] = true;
								if (grid[indexI][indexJ - 1] == '1')
									isle.offer(index - 1);
							}
						}
					}
				}
			}
			if (!isle.isEmpty())
				result++;
			while (!isle.isEmpty()) {
				int index = isle.poll();
				int indexI = index / colLen;
				int indexJ = index % colLen;
				if (indexI < rowLen - 1) {
					if (!visited[indexI + 1][indexJ]) {
						visited[indexI + 1][indexJ] = true;
						if (grid[indexI + 1][indexJ] == '1')
							isle.offer(index + colLen);
					}
				}
				if (indexI > 0) {
					if (!visited[indexI - 1][indexJ]) {
						visited[indexI - 1][indexJ] = true;
						if (grid[indexI - 1][indexJ] == '1')
							isle.offer(index - colLen);
					}
				}
				if (indexJ < colLen - 1) {
					if (!visited[indexI][indexJ + 1]) {
						visited[indexI][indexJ + 1] = true;
						if (grid[indexI][indexJ + 1] == '1')
							isle.offer(index + 1);
					}
				}
				if (indexJ > 0) {
					if (!visited[indexI][indexJ - 1]) {
						visited[indexI][indexJ - 1] = true;
						if (grid[indexI][indexJ - 1] == '1')
							isle.offer(index - 1);
					}
				}
			}
		}
		return result;
	}
}
