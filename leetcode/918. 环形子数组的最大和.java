import java.util.Collections;

class Solution {
  public int maxSubarraySumCircular(int[] nums) {
    ArrayList<Integer> l = new ArrayList<>();
    ArrayList<Integer> l2 = new ArrayList<>();
    l.add(nums[0]);
    int total = nums[0];
    l2.add(nums[0]);
    for (int i = 1; i < nums.length; i++) {
      int t = Math.max(nums[i], l.get(i - 1) + nums[i]);
      l.add(t);
      int t2 = Math.min(nums[i], l2.get(i - 1) + nums[i]);
      l2.add(t2);
      total += nums[i];
    }
    int maxn = Collections.max(l);
    int minn = Collections.min(l2);
    return maxn > 0 ? Math.max(maxn, total - minn) : maxn;
  }
}