class Solution {
  public int[] leftRigthDifference(int[] nums) {
    // 统计前缀和
    int[] prefixSum = new int[nums.length];
    prefixSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i];
    }
    int[] result = new int[nums.length];
    result[0] = Math.abs(prefixSum[nums.length - 1] - prefixSum[0]);
    for (int i = 1; i < nums.length; i++) {
      result[i] = Math.abs((prefixSum[nums.length - 1] - prefixSum[i]) - prefixSum[i - 1]);
    }
    return result;
  }
}