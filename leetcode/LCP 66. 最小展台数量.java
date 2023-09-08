class Solution {
  public int minNumBooths(String[] demand) {
    int[] demandMap = new int[26];
    for (String s : demand) {
      int[] arr = new int[26];
      for (int i = 0; i < s.length(); i++) {
        int p = s.charAt(i) - 'a';
        arr[p]++;
      }
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == 0)
          continue;
        if (arr[i] > demandMap[i])
          demandMap[i] = arr[i];
      }
    }
    int ans = 0;
    for (int i = 0; i < demandMap.length; i++)
      ans += demandMap[i];
    return ans;
  }
}