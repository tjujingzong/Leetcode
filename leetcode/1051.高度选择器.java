import java.util.Arrays;
import java.util.Collections;

class Solution {
  public int heightChecker(int[] heights) {
    int[] heights2 = heights.clone();
    Arrays.sort(heights);
    int ans=0;
    for (int i = 0; i < heights2.length; i++) {
      if (heights[i] != heights2[i])
        ans++;
    }
    return ans;
  }
}