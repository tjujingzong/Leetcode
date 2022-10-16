import java.util.HashSet;

class Solution {
  public int countDistinctIntegers(int[] nums) {
    HashSet<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
      set.add(Integer.valueOf(new StringBuilder(String.valueOf(nums[i])).reverse().toString()));
    }
    return set.size();
  }
}