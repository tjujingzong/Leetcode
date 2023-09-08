import java.util.TreeMap;

class Solution {
  public int minOperations(int[] nums, int[] numsDivide) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]))
        map.put(nums[i], map.get(nums[i]) + 1);
      else
        map.put(nums[i], 1);
    }
    int ans = 0;
    boolean flag;
    for (Integer e : map.keySet()) {
      flag = true;
      for (int i = 0; i < numsDivide.length; i++) {
        if (numsDivide[i] % e != 0) {
          flag = false;
          break;
        }
      }
      if (flag)
        return ans;
      ans += map.get(e);
    }
    return -1;
  }
}