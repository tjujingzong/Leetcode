class Solution {
  public int numSubarrayBoundedMax(int[] A, int L, int R) {
      // 最大元素满足大于等于L小于等于R的子数组个数 = 最大元素小于等于R的子数组个数 - 最大元素小于L的子数组个数
      return numSubarrayBoundedMax(A, R) - numSubarrayBoundedMax(A, L - 1);
  }

  private int numSubarrayBoundedMax(int[] A, int Max) {
      int res = 0;
      int numSubarry = 0;
      for (int num : A) {
          if (num <= Max) {
              numSubarry++;
              res += numSubarry;
          } else {
              numSubarry = 0;
          }
      }
      return res;
  }
}