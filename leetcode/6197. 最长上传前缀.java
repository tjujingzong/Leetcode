import java.util.HashMap;

class Solution {
  public int xorAllNums(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums1.length; i++)
      map.put(nums1[i], map.getOrDefault(nums1[i], 0) + len2);
    for (int i = 0; i < nums2.length; i++)
      map.put(nums2[i], map.getOrDefault(nums2[i], 0) + len1);
    int ans = 0;
    for (int i : map.keySet()) {
      if (map.get(i) % 2 == 0)
        continue;
      ans ^= i;
    }
    return ans;
  }
}