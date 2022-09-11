import java.util.TreeMap;

class Solution {
  public int mostFrequentEven(int[] nums) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 0)
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    int ans = -1;
    int times = 0;
    for (int i : map.keySet()) {
      if (map.get(i) > times) {
        ans = i;
        times = map.get(i);
      }
    }
    return ans;
  }
}