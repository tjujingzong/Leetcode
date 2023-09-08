import java.util.List;

/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

// @lc code=start
class Solution {
  public List<Integer> countSmaller(int[] nums) {
    int[] arr = discrete(nums); // 离散化nums
    int n = arr.length;
    for (int i = 0; i < n / 2; i++) { // 反转arr
      int tmp = arr[i];
      arr[i] = arr[n - 1 - i];
      arr[n - 1 - i] = tmp;
    }
    BIT bit = new BIT(arr);
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      res.add(bit.query(arr[i]));
      bit.add(arr[i], 1);
    }
    Collections.reverse(res); // 反转
    return res;
  }

  private int[] discrete(int[] nums) { // 离散化
    int n = nums.length;
    int[] tmp = new int[n];
    System.arraycopy(nums, 0, tmp, 0, n);
    Arrays.sort(tmp);
    for (int i = 0; i < n; ++i) {
      nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
    }
    return nums;
  }
}

class BIT {
  int n;
  int[] tree, occurs;

  public BIT(int[] nums) {
    this.n = nums.length;
    this.tree = new int[n + 1];
    this.occurs = new int[n + 1];
  }

  public int query(int k) { // 查询前k项和
    int ans = 0;
    for (int i = k; i > 0; i -= lowbit(i)) { // 下一个左邻区间和结点下标为i -= lowbit(i)
      ans += tree[i];
    }
    return ans - occurs[k]; // 去掉相等的个数
  }

  public void add(int k, int x) { // 为第k项加上x
    occurs[k]++; // 记录同一个数处理的次数
    for (int i = k; i <= n; i += lowbit(i)) { // 下一个区间和结点下标为i += lowbit(i)
      tree[i] += x;
    }
  }

  private int lowbit(int i) {
    return i & -i;
  }
}
// @lc code=end
