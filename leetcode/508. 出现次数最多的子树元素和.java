import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  HashMap<Integer, Integer> mapp = new HashMap<>();// 这里不能用static 不然测试和提交时结果不一样

  public int[] findFrequentTreeSum(TreeNode root) {
    int maxn = 0;
    getsum(root);
    for (Integer value : mapp.values()) {
      if (value > maxn)
        maxn = value;
    }
    ArrayList<Integer> anslist = new ArrayList<>();
    for (Integer key : mapp.keySet()) {
      if (mapp.get(key) == maxn)
        anslist.add(key);
    }
    int[] ans = new int[anslist.size()];
    for (int i = 0; i < ans.length; i++)
      ans[i] = anslist.get(i);
    return ans;
  }

  public int getsum(TreeNode root) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null) {
      if (mapp.containsKey(root.val))
        mapp.compute(root.val, (key, value) -> value + 1);
      else
        mapp.put(root.val, 1);
      return root.val;
    }
    int sum = getsum(root.left) + getsum(root.right) + root.val;
    if (mapp.containsKey(sum))
      mapp.compute(sum, (key, value) -> value + 1);
    else
      mapp.put(sum, 1);
    return sum;
  }
}