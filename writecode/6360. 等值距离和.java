import java.util.ArrayList;
import java.util.HashMap;

class Solution {
  public long[] distance(int[] nums) {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int n = nums.length;
    long[] ans = new long[n];

    for (int i = 0; i < n; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], new ArrayList<>());
      }
      map.get(nums[i]).add(i);
    }

    for (ArrayList<Integer> list : map.values()) {
      if (list.size() == 1)
        continue;
      int frist = list.get(0);
      long sum = 0;
      for (int i = 1; i < list.size(); i++) {
        int curr = list.get(i);
        sum += curr - frist;
      }
      ans[frist] = sum;
      for (int i = 1; i < list.size(); i++) {
        int prev = list.get(i - 1);
        int curr = list.get(i);
        ans[curr] = ans[prev] - (curr - prev) * (list.size() - i) + (curr - prev) * i;
      }
    }
    return ans;
  }
}
