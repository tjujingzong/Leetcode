import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
  public int findPairs(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      if (map.containsKey(nums[i]))
        continue;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] - nums[i] > k)
          break;
        if (nums[j] - nums[i] == k)
          map.put(nums[i], nums[j]);
      }
    }
    return map.size();
  }
}