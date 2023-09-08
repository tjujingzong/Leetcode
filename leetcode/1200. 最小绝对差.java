import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);
    int mingap = 100000;
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < arr.length - 1; i++) {
      mingap = Math.min(mingap, arr[i + 1] - arr[i]);
    }
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i + 1] - arr[i] == mingap) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(arr[i]);
        l.add(arr[i + 1]);
        ans.add(l);
      }
      return ans;
    }
  }
}