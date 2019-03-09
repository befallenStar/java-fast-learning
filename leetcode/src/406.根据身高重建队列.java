import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 *
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/description/
 *
 * algorithms
 * Medium (59.08%)
 * Total Accepted:    1.6K
 * Total Submissions: 2.7K
 * Testcase Example:  '[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]'
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 * 
 * 注意：
 * 总人数少于1100人。
 * 
 * 示例
 * 
 * 
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * 
 */
class Solution {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (o1, o2) -> (o2[0] - o1[0]) != 0 ? (o2[0] - o1[0]) : (o1[1] - o2[1]));
		for (int i = 0; i < people.length; i++)
			if (i != people[i][1])
				insertElement(people, i, people[i][1]);
		return people;
	}

	private void insertElement(int[][] o, int key, int index) {
		int[] ele = o[key];
		// System.arraycopy(src, srcPos, dest, destPos, length);
		System.arraycopy(o, index, o, index + 1, key - index);
		o[index] = ele;
	}
}
