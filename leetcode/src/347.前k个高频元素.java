import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前K个高频元素
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (53.63%)
 * Total Accepted:    8.2K
 * Total Submissions: 15.2K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 
 * 说明：
 * 
 * 
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 
 * 
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        if (k == nums.length) {
            for (int i = 0; i < k; i++)
                result.add(nums[i]);
            return result;
        } else {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i]))
                    map.put(nums[i], 1);
                else
                    map.put(nums[i], map.get(nums[i]) + 1);
            }
            Set<Map.Entry<Integer, Integer>> set = map.entrySet();
            List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(set);
            list.sort((o1, o2) -> o2.getValue() - o1.getValue());
            for (int i = 0; i < k; i++) {
                result.add(list.get(i).getKey());
            }
        }
        return result;
    }
}
