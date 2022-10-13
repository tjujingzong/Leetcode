import java.util.ArrayList;
import java.util.List;

class Solution {
  static int N = 80001;
  static int B = 40001;
  static int[] tree = new int[N + 1];

  public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
    int n = nums1.length;
    int[] nums3 = new int[n];
    for (int i = 0; i < n; i++) {
      nums3[i] = nums1[i] - nums2[i];
    }
    List<Integer> ans = new ArrayList<>();
    // 记录某个数右侧频率
    for (int x : nums3)
      update(B + x, 1);
    for (int x : nums3) {
      // 访问某数后，不可能出现在剩余树的右侧，因此需要对其频率进行减一
      update(B + x, -1);
      // 范围查询
      ans.add(query(B + x - diff - 1));
    }
    long res = 0;
    for (int x : ans)
      res += x;
    return (long) (n - 1) * n / 2 - res;
  }

  public void update(int k, int v) {
    while (k <= N) {
      tree[k] += v;
      k += lowBit(k);
    }
  }

  public int query(int k) {
    int res = 0;
    while (k > 0) {
      res += tree[k];
      k -= lowBit(k);
    }
    return res;
  }

  public int lowBit(int k) {
    return k & (-k);
  }

}