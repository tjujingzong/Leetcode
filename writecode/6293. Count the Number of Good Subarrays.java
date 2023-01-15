import java.util.HashMap;

class Solution {
  public long countGood(int[] nums, int k) {
    // 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
    // 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
    // 子数组 是原数组中一段连续 非空 的元素序列。
    long ans = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    int i = 0;
    int j = -1;
    int count = 0;
    while (i < nums.length) {
      if (i != 0) {
        map.put(nums[i - 1], map.get(nums[i - 1]) - 1);
        if (map.get(nums[i - 1]) >= 1) {
          count -= map.get(nums[i - 1]);
        }
      }
      while (j < nums.length - 1) {
        if (count >= k) {
          break;
        }
        j++;
        if (map.containsKey(nums[j])) {
          map.put(nums[j], map.get(nums[j]) + 1);
        } else {
          map.put(nums[j], 1);
        }
        if (map.get(nums[j]) >= 2) {
          count += map.get(nums[j]) - 1;
        }
      }
      if (count >= k) {
        ans += nums.length - j;
        System.out.println("i: " + i + ", j: " + j + ", ans: " + ans + ",count: " + count);
      }
      i++;
    }
    return ans;
  }
}