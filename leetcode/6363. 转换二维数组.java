import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> findMatrix(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    for (int n : nums) {
      boolean flag = false;
      for (List<Integer> list : ans) {
        if (!list.contains(n)) {
          list.add(n);
          flag = true;
          break;
        }
      }
      if (flag)
        continue;
      else {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        ans.add(list);
      }
    }
    return ans;
  }
}