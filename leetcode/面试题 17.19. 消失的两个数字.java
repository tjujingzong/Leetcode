class Solution {
  public int[] missingTwo(int[] nums) {
      int n = nums.length + 2;
      int sum = 0;
      for (int i : nums) sum += i;
      int ts = (1 + n) * n / 2 - sum; //两个缺失元素之和
      int m = ts / 2; //两个元素之间的“分界”（一个缺失元素大于这个值，另一个小于这个值）

      // 将问题转换为求一个缺失元素
      sum = 0;
      for (int i : nums) {
          if (i <= m) sum += i;
      }
      int res = (1 + m) * m / 2 - sum;
      return new int[] {res, ts - res};
  }
}

作者：Feyl
链接：https://leetcode.cn/problems/missing-two-lcci/solution/by-feyl-jvqk/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。