import java.util.Arrays;

class Solution {
  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    int max1 = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
    int max2 = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
    for (int i = 0; i < horizontalCuts.length - 1; i++) {
      if (horizontalCuts[i + 1] - horizontalCuts[i] > max1)
        max1 = horizontalCuts[i + 1] - horizontalCuts[i];
    }
    for (int i = 0; i < verticalCuts.length - 1; i++)
      if (verticalCuts[i + 1] - verticalCuts[i] > max2)
        max2 = verticalCuts[i + 1] - verticalCuts[i];
    int ans = (int) ((long) max1 * max2 % 1000000007);
    return ans;
  }

}