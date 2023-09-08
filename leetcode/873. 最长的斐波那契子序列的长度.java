import java.util.ArrayList;

class Solution {
  public int lenLongestFibSubseq(int[] arr) {
    int ans = 2;
    for (int i = 0; i < arr.length - 2; i++) {
      if (arr.length - i <= ans)
        break;
      for (int j = i + 1; j < arr.length - 1; j++) {
        int x1 = arr[i];
        int x2 = arr[j];
        int tans = 2;
        for (int k = j + 1; k < arr.length; k++) {
          if (x1 + x2 < arr[k])
            break;
          if (x1 + x2 == arr[k]) {
            x1 = x2;
            x2 = arr[k];
            tans++;
          }
        }
        if (tans > ans)
          ans = tans;
      }
    }
    return ans > 2 ? ans : 0;
  }

}