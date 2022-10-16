import java.math.BigInteger;
import java.util.ArrayList;

class Solution {
  int mod = 1000000000 + 7;

  public int[] productQueries(int n, int[][] queries) {
    String s = Integer.toBinaryString(n);
    char[] arr = s.toCharArray();
    ArrayList<Long> powers = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[arr.length - 1 - i] == '1')
        powers.add(1L << i);
    }
    BigInteger[] presum = new BigInteger[powers.size()];
    presum[0] = BigInteger.valueOf(powers.get(0));
    for (int i = 1; i < presum.length; i++) {
      presum[i] = presum[i - 1].multiply(BigInteger.valueOf(powers.get(i)));
    }
    int[] ans = new int[queries.length];
    for (int i = 0; i < ans.length; i++) {
      BigInteger t;
      if (queries[i][0] == 0)
        t = presum[queries[i][1]];
      else
        t = presum[queries[i][1]].divide(presum[queries[i][0] - 1]);
      t = t.mod(BigInteger.valueOf(mod));
      ans[i] = t.intValue();
    }
    return ans;
  }
}