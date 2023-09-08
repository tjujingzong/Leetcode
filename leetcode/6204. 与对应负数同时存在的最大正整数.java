import java.util.ArrayList;

class Solution {
  public int findMaxK(int[] nums) {
    ArrayList p = new ArrayList<>();
    ArrayList n = new ArrayList<>();
    int ans = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0)
        p.add(nums[i]);
      else
        n.add(nums[i]);
    }
    for (int i = 0; i < p.size(); i++) {
      int pp = (int) p.get(i);
      if (n.contains(-pp)) {
        ans = Math.max(ans, pp);
      }
    }
    return ans;
  }
}