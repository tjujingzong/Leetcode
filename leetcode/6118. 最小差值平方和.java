
import java.util.TreeMap;

class Solution {
  public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
    int n = nums1.length;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    map.put(0, n);// 最佳情况全为0,防止后面lowerkey取不到
    for (int i = 0; i < n; i++) {
      int gaps = Math.abs(nums1[i] - nums2[i]);
      if (map.containsKey(gaps))
        map.put(gaps, map.get(gaps) + 1);
      else
        map.put(gaps, 1);
    }
    int left = k1 + k2;
    while (left > 0) {
      int maxgap = map.lastKey();
      int times = map.get(maxgap);
      if (maxgap == 0)
        break;
      Integer nextgap = map.lowerKey(maxgap);
      if (left >= (maxgap - nextgap) * times) {
        map.put(nextgap, times + map.get(nextgap));
        left -= (maxgap - nextgap) * times;
        map.remove(maxgap);
      } else if (left >= times) {
        int ns = left / times;
        map.remove(maxgap);
        map.put(maxgap - ns, times);
        left -= times * ns;
      } else {
        map.put(maxgap, times - left);
        if (map.containsKey(maxgap - 1))
          map.put(maxgap - 1, map.get(maxgap - 1) + left);
        else
          map.put(maxgap - 1, left);
        left = 0;
      }
    }
    long ans = 0;
    for (Integer e : map.keySet()) {
      int times = map.get(e);
      ans += (long) e * e * times;
    }
    return ans;
  }
}
