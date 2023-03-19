// You are given a 0-indexed integer array nums. In one operation, you can:

// Choose two different indices i and j such that 0 <= i, j < nums.length.
// Choose a non-negative integer k such that the kth bit (0-indexed) in the binary representation of nums[i] and nums[j] is 1.
// Subtract 2k from nums[i] and nums[j].
// A subarray is beautiful if it is possible to make all of its elements equal to 0 after applying the above operation any number of times.

// Return the number of beautiful subarrays in the array nums.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:

// Input: nums = [4,3,1,2,4]
// Output: 2
// Explanation: There are 2 beautiful subarrays in nums: [4,3,1,2,4] and [4,3,1,2,4].
// - We can make all elements in the subarray [3,1,2] equal to 0 in the following way:
//   - Choose [3, 1, 2] and k = 1. Subtract 21 from both numbers. The subarray becomes [1, 1, 0].
//   - Choose [1, 1, 0] and k = 0. Subtract 20 from both numbers. The subarray becomes [0, 0, 0].
// - We can make all elements in the subarray [4,3,1,2,4] equal to 0 in the following way:
//   - Choose [4, 3, 1, 2, 4] and k = 2. Subtract 22 from both numbers. The subarray becomes [0, 3, 1, 2, 0].
//   - Choose [0, 3, 1, 2, 0] and k = 0. Subtract 20 from both numbers. The subarray becomes [0, 2, 0, 2, 0].
//   - Choose [0, 2, 0, 2, 0] and k = 1. Subtract 21 from both numbers. The subarray becomes [0, 0, 0, 0, 0].

class Solution {
  public long beautifulSubarrays(int[] nums) {
    // 前缀异或数组
    long ans = 0;
    int[] pre = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      pre[i + 1] = pre[i] ^ nums[i]
      map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
    }
    // 计算答案
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int k = entry.getKey();
      int v = entry.getValue();
      ans += (long) v * (v - 1) / 2;
    }
    return ans;
  }
}