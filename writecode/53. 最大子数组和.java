import java.util.ArrayList;
import java.util.Collections;

class Solution {
  public int maxSubArray(int[] nums) {
    ArrayList<Integer> l = new ArrayList<>();
    l.add(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      int t = Math.max(nums[i], l.get(i - 1) + nums[i]);
      l.add(t);
    }
    return Collections.max(l);
  }
}