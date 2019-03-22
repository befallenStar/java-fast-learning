import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 *
 * https://leetcode-cn.com/problems/max-area-of-island/description/
 *
 * algorithms
 * Medium (53.64%)
 * Total Accepted:    5.1K
 * Total Submissions: 9.5K
 * Testcase Example:  '[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]'
 *
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地)
 * 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * 
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * 
 * 示例 1:
 * 
 * 
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,1,1,0,1,0,0,0,0,0,0,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,0,1,0,0],
 * ⁠[0,1,0,0,1,1,0,0,1,1,1,0,0],
 * ⁠[0,0,0,0,0,0,0,0,0,0,1,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,1,0,0,0],
 * ⁠[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 
 * 
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 * 
 * 示例 2:
 * 
 * 
 * [[0,0,0,0,0,0,0,0]]
 * 
 * 对于上面这个给定的矩阵, 返回 0。
 * 
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 * 
 */
class Solution {
	public int maxAreaOfIsland(int[][] grid) {
		if (grid.length * grid[0].length == 1)
			if (grid[0][0] == 1)
				return 1;
			else
				return 0;
		Queue<Integer> isle = new LinkedList<>();
		int result = 0;
		int tmp = 0;
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
				visited[i][j] = true;
				if (grid[i][j] == 1) {
					isle.offer(i * colLen + j);
					tmp++;
				} else {
					while (!isle.isEmpty()) {
						int index = isle.poll();
						int indexI = index / colLen;
						int indexJ = index % colLen;
						if (indexI < rowLen - 1) {
							if (!visited[indexI + 1][indexJ]) {
								visited[indexI + 1][indexJ] = true;
								if (grid[indexI + 1][indexJ] == 1) {
									isle.offer(index + colLen);
									tmp++;
								}
							}
						}
						if (indexI > 0) {
							if (!visited[indexI - 1][indexJ]) {
								visited[indexI - 1][indexJ] = true;
								if (grid[indexI - 1][indexJ] == 1) {
									isle.offer(index - colLen);
									tmp++;
								}
							}
						}
						if (indexJ < colLen - 1) {
							if (!visited[indexI][indexJ + 1]) {
								visited[indexI][indexJ + 1] = true;
								if (grid[indexI][indexJ + 1] == 1) {
									isle.offer(index + 1);
									tmp++;
								}
							}
						}
						if (indexJ > 0) {
							if (!visited[indexI][indexJ - 1]) {
								visited[indexI][indexJ - 1] = true;
								if (grid[indexI][indexJ - 1] == 1) {
									isle.offer(index - 1);
									tmp++;
								}
							}
						}
					}
					result = tmp > result ? tmp : result;
					tmp = 0;
				}
			}
			while (!isle.isEmpty()) {
				int index = isle.poll();
				int indexI = index / colLen;
				int indexJ = index % colLen;
				if (indexI < rowLen - 1) {
					if (!visited[indexI + 1][indexJ]) {
						visited[indexI + 1][indexJ] = true;
						if (grid[indexI + 1][indexJ] == 1) {
							isle.offer(index + colLen);
							tmp++;
						}
					}
				}
				if (indexI > 0) {
					if (!visited[indexI - 1][indexJ]) {
						visited[indexI - 1][indexJ] = true;
						if (grid[indexI - 1][indexJ] == 1) {
							isle.offer(index - colLen);
							tmp++;
						}
					}
				}
				if (indexJ < colLen - 1) {
					if (!visited[indexI][indexJ + 1]) {
						visited[indexI][indexJ + 1] = true;
						if (grid[indexI][indexJ + 1] == 1) {
							isle.offer(index + 1);
							tmp++;
						}
					}
				}
				if (indexJ > 0) {
					if (!visited[indexI][indexJ - 1]) {
						visited[indexI][indexJ - 1] = true;
						if (grid[indexI][indexJ - 1] == 1) {
							isle.offer(index - 1);
							tmp++;
						}
					}
				}
			}
			result = tmp > result ? tmp : result;
			tmp = 0;
		}
		return result;
	}
}
