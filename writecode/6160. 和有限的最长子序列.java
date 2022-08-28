import java.util.Arrays;

class Solution {
  public int[] answerQueries(int[] nums, int[] queries) {
    Arrays.sort(nums);
    int n = nums.length;
    int m = queries.length;
    int[] ans = new int[m];
    int[] presum = new int[n];
    presum[0] = nums[0];
    for (int i = 1; i < n; i++) {
      presum[i] = nums[i] + presum[i - 1];
    }
    for (int i = 0; i < m; i++) {
      int p = 0;
      for (int j = 0; j < n; j++) {
        if (queries[i] >= presum[j])
          p++;
        else
          break;
      }
      ans[i] = p;
    }
    return ans;
  }
}