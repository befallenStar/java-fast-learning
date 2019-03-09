/*
 * @lc app=leetcode.cn id=780 lang=java
 *
 * [780] 最多能完成排序的块
 *
 * https://leetcode-cn.com/problems/reaching-points/description/
 *
 * algorithms
 * Hard (24.44%)
 * Total Accepted:    198
 * Total Submissions: 810
 * Testcase Example:  '9\n5\n12\n8'
 *
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 * 
 * 给定一个起点 (sx, sy) 和一个终点 (tx, ty)，如果通过一系列的转换可以从起点到达终点，则返回 True ，否则返回 False。
 * 
 * 
 * 示例:
 * 输入: sx = 1, sy = 1, tx = 3, ty = 5
 * 输出: True
 * 解释:
 * 可以通过以下一系列转换从起点转换到终点：
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 * 
 * 输入: sx = 1, sy = 1, tx = 2, ty = 2
 * 输出: False
 * 
 * 输入: sx = 1, sy = 1, tx = 1, ty = 1
 * 输出: True
 * 
 * 
 * 
 * 注意:
 * 
 * 
 * sx, sy, tx, ty 是范围在 [1, 10^9] 的整数。
 * 
 * 
 */
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty)
            return true;
        if (tx < sx || ty < sy)
            return false;
        if (tx == sx && ty != sy)
            if ((ty - sy) % sx == 0)
                return true;
            else
                return false;
        if (tx != sx && ty == sy)
            if ((tx - sx) % sy == 0)
                return true;
            else
                return false;
        if (tx > ty)
            return reachingPoints(sx, sy, tx - ty, ty);
        else
            return reachingPoints(sx, sy, tx, ty - tx);
    }
}