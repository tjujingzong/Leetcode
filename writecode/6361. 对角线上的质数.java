class Solution {
  public int diagonalPrime(int[][] nums) {
    int ans = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (isPrime(nums[i][i]))
        ans = Math.max(nums[i][i], ans);
      if (isPrime(nums[i][n - 1 - i]))
        ans = Math.max(nums[i][n - 1 - i], ans);
    }
    return ans;
  }

  private boolean isPrime(int i) {
    if (i == 1) {
      return false;
    }
    for (int j = 2; j * j <= i; j++) {
      if (i % j == 0) {
        return false;
      }
    }
    return true;
  }
}