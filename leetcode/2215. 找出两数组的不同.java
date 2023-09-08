import java.util.HashSet;
import java.util.List;

class Solution {
  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    HashSet<Integer> n1 = new HashSet<>();
    HashSet<Integer> n2 = new HashSet<>();
    for (int i = 0; i < nums1.length; i++)
      n1.add(nums1[i]);
    for (int i = 0; i < nums2.length; i++)
      n2.add(nums1[i]);
    List<Integer> l1 = new ArrayList<Integer>();
    for (Integer e : n1) {
      if (!n2.contains(e))
        l1.add(e);
    }
    List<Integer> l2 = new ArrayList<Integer>();
    for (Integer e : n2) {
      if (!n1.contains(e))
        l2.add(e);
    }
    ans.add(l1);
    ans.add(l2);
    return ans;
  }
}