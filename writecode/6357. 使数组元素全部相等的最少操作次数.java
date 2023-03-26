import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Long> minOperations(int[] nums, int[] queries) {
    List<Long> ans = new ArrayList<>();
    Arrays.sort(nums);
    long[] prefix = new long[nums.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      prefix[i] = prefix[i - 1] + nums[i - 1];
    }
    for (int i = 0; i < queries.length; i++) {
      int index = Arrays.binarySearch(nums, queries[i]);
      if (index < 0) {
        index = -index - 1;
      }
      long sum = queries[i] * (long) index - prefix[index];
      sum += prefix[nums.length] - prefix[index] - queries[i] * (long) (nums.length - index);
      ans.add(sum);
    }
    return ans;
  }
}