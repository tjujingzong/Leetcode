class RURQBIT { // 区间修改区间查询
  int[] diff, tree, helperTree; // nums为输入数组，diff为差分数组，tree是diff的区间和构成的逻辑树，helperTree是辅助逻辑树
  int n;

  public RURQBIT(int[] nums) {
    this.n = nums.length - 1; // 有效元素个数
    this.diff = new int[n + 1];
    this.tree = new int[n + 1];
    this.helperTree = new int[n + 1];
    for (int i = 1; i <= n; i++) { // 求diff[]
      diff[i] = nums[i] - nums[i - 1];
    }
    for (int i = 1; i <= n; i++) { // 初始化tree[]和helperTree
      add(tree, i, diff[i]);
      add(helperTree, i, (i - 1) * diff[i]);
    }
  }

  // 查询区间和: 求nums[l]到nums[r]之和 preSum(r)-preSum(l-1)
  public int sum(int l, int r) {
    int preSum0 = (l - 1) * query(tree, l - 1) - query(helperTree, l - 1);
    int preSum1 = r * query(tree, r) - query(helperTree, r);
    return preSum1 - preSum0;
  }

  public void rangeUpdate(int l, int r, int x) { // 区间修改
    add(tree, l, x);
    add(tree, r + 1, -x);
    add(helperTree, l, (l - 1) * x);
    add(helperTree, r + 1, r * (-x));
  }

  public int query(int[] thisTree, int k) { // 区间查询，求前缀和 preSum[k]
    int ans = 0;
    for (int i = k; i > 0; i -= lowbit(i)) { // 下一个左邻区间和结点下标为i -= lowbit(i)
      ans += thisTree[i];
    }
    return ans;
  }

  private void add(int[] thisTree, int k, int x) { // 为第k个结点thisTree[k]加上x
    for (int i = k; i <= n; i += lowbit(i)) { // 下一个区间和结点下标为i += lowbit(i)
      thisTree[i] += x; // 包含第k项的区间都加上x
    }
  }

  private int lowbit(int i) {
    return i & -i;
  }
}

