import java.util.HashMap;

class Solution {
  public int findSmallestInteger(int[] nums, int value) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (num < 0)
        num = num + value * (Math.abs(num) / value + 1);
      int mod = num % value;
      map.put(mod, map.getOrDefault(mod, 0) + 1);
    }
    int mex = 0;
    while (true) {
      if (!map.containsKey(mex % value))
        break;
      if (map.get(mex % value) == 0)
        break;
      map.put(mex % value, map.get(mex % value) - 1);
      mex++;
    }
    return mex;
  }
}