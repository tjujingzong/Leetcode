class Solution {
  public int minElements(int[] nums, int limit, int goal) {
    long ans = 0;
    long sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    long gap = Math.abs(goal - sum);
    ans = (gap % limit == 0 ? gap / limit : gap / limit + 1);
    return (int) ans;
  }
}