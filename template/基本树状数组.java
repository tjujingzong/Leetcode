class BIT{
  int[] nums, tree; // nums为输入数组，tree为区间和数组
  int n; // nums大小
  public BIT(int[] nums){
      this.nums = nums;
      this.n = nums.length;
      this.tree = new int[this.n + 1];
      for(int i = 0; i < n; i++){
          add(i + 1, nums[i]);
      }
  }
  public int sum(int l, int r){ // 查询区间和: 求nums[l]到nums[r]之和
      return query(r + 1) - query(l);
  }
  public void update (int i, int val){ // 单点修改: 令nums[i] = val
      add(i + 1, val - nums[i]); // nums[i]对应树状数组中的第i+1项tree[i+1]
      nums[i] = val; // 更新 nums[i] 为val
  }
  private int query(int n){ // 查询前n项和
      int ans = 0;
      for(int i = n; i > 0; i -= lowbit(i)){ // 下一个左邻区间和结点下标为i -= lowbit(i)
          ans += tree[i];
      }
      return ans;
  }
  private void add(int k, int x){ // 单点修改: nums[k-1] += x (nums[k-1]是 nums 中的第 k 项)
      for(int i = k; i <= n; i += lowbit(i)){ // 下一个区间和结点下标为i += lowbit(i)
          tree[i] += x; // 包含第k项的区间都加上x
      }
  }
  private int lowbit(int i){
      return i & -i;
  }
}
