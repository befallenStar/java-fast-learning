import java.util.*;

/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 *
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/description/
 *
 * algorithms
 * Medium (37.96%)
 * Total Accepted:    901
 * Total Submissions: 2.4K
 * Testcase Example:  '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 
 * 给定下面的 5x5 矩阵:
 * 
 * ⁠ 太平洋 ~   ~   ~   ~   ~ 
 * ⁠      ~  1   2   2   3  (5) *
 * ⁠      ~  3   2   3  (4) (4) *
 * ⁠      ~  2   4  (5)  3   1  *
 * ⁠      ~ (6) (7)  1   4   5  *
 * ⁠      ~ (5)  1   1   2   4  *
 * ⁠         *   *   *   *   * 大西洋
 * 
 * 返回:
 * 
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 * 
 * 
 * 
 * 
 */
class Solution {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		Set<int[]> setPacific = new HashSet<>();
		Set<int[]> setAtlantic = new HashSet<>();
		Set<int[]> result = new HashSet<>();
		if (matrix == null || matrix.length == 0)
			return new ArrayList<>();
		setPacific = toPacific(matrix);
		setAtlantic = toAtlantic(matrix);
		for (int[] i : setAtlantic) {
			for (int[] j : setPacific) {
				if (i[0] == j[0] && i[1] == j[1])
					result.add(i);
			}
		}
		return new ArrayList<>(result);
	}

	private Set<int[]> toAtlantic(int[][] matrix) {
		Queue<int[]> q = new LinkedList<>();
		Set<int[]> s = new HashSet<>();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				visited[i][j] = false;
		for (int i = 0; i < matrix.length; i++) {
			int[] r = { i, matrix[0].length - 1 };
			visited[i][matrix[0].length - 1] = true;
			q.add(r);
		}
		for (int i = 0; i < matrix[0].length - 1; i++) {
			int[] r = { matrix.length - 1, i };
			visited[matrix.length - 1][i] = true;
			q.add(r);
		}
		while (!q.isEmpty()) {
			int[] r = q.poll();
			s.add(r);
			if (r[0] > 0)
				if (!visited[r[0] - 1][r[1]]) {
					if (matrix[r[0] - 1][r[1]] >= matrix[r[0]][r[1]]) {
						visited[r[0] - 1][r[1]] = true;
						int[] n = { r[0] - 1, r[1] };
						q.add(n);
					}
				}
			if (r[1] > 0)
				if (!visited[r[0]][r[1] - 1]) {
					if (matrix[r[0]][r[1] - 1] >= matrix[r[0]][r[1]]) {
						visited[r[0]][r[1] - 1] = true;
						int[] n = { r[0], r[1] - 1 };
						q.add(n);
					}
				}
			if (r[0] < matrix.length - 1)
				if (!visited[r[0] + 1][r[1]]) {
					if (matrix[r[0] + 1][r[1]] >= matrix[r[0]][r[1]]) {
						visited[r[0] + 1][r[1]] = true;
						int[] n = { r[0] + 1, r[1] };
						q.add(n);
					}
				}
			if (r[1] < matrix[0].length - 1)
				if (!visited[r[0]][r[1] + 1]) {
					if (matrix[r[0]][r[1] + 1] >= matrix[r[0]][r[1]]) {
						visited[r[0]][r[1] + 1] = true;
						int[] n = { r[0], r[1] + 1 };
						q.add(n);
					}
				}
		}
		return s;
	}

	private Set<int[]> toPacific(int[][] matrix) {
		Queue<int[]> q = new LinkedList<>();
		Set<int[]> s = new HashSet<>();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				visited[i][j] = false;
		for (int i = 0; i < matrix.length; i++) {
			int[] r = { i, 0 };
			visited[i][0] = true;
			q.add(r);
		}
		for (int i = 1; i < matrix[0].length; i++) {
			int[] r = { 0, i };
			visited[0][i] = true;
			q.add(r);
		}
		while (!q.isEmpty()) {
			int[] r = q.poll();
			s.add(r);
			if (r[0] > 0)
				if (!visited[r[0] - 1][r[1]]) {
					if (matrix[r[0] - 1][r[1]] >= matrix[r[0]][r[1]]) {
						visited[r[0] - 1][r[1]] = true;
						int[] n = { r[0] - 1, r[1] };
						q.add(n);
					}
				}
			if (r[1] > 0)
				if (!visited[r[0]][r[1] - 1]) {
					if (matrix[r[0]][r[1] - 1] >= matrix[r[0]][r[1]]) {
						visited[r[0]][r[1] - 1] = true;
						int[] n = { r[0], r[1] - 1 };
						q.add(n);
					}
				}
			if (r[0] < matrix.length - 1)
				if (!visited[r[0] + 1][r[1]]) {
					if (matrix[r[0] + 1][r[1]] >= matrix[r[0]][r[1]]) {
						visited[r[0] + 1][r[1]] = true;
						int[] n = { r[0] + 1, r[1] };
						q.add(n);
					}
				}
			if (r[1] < matrix[0].length - 1)
				if (!visited[r[0]][r[1] + 1]) {
					if (matrix[r[0]][r[1] + 1] >= matrix[r[0]][r[1]]) {
						visited[r[0]][r[1] + 1] = true;
						int[] n = { r[0], r[1] + 1 };
						q.add(n);
					}
				}
		}
		return s;
	}
}
