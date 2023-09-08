class Solution {
  public long countBadPairs(int[] nums) {
    long n = nums.length;
    for (int i = 0; i < nums.length; i++) {
      nums[i] -= i;
    }
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    for (int num : nums) {
      m.put(num, m.getOrDefault(num, 0) + 1);
    }

    long ans = 0;
    for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
      int v = entry.getValue();
      ans += (long) v * (v - 1) / 2;
    }

    return n * (n - 1) / 2 - ans;

  }
}