class Solution {
  public int garbageCollection(String[] garbage, int[] travel) {
    int cm = 0, cp = 0, cg = 0;
    int lastm = 0, lastp = 0, lastg = 0;
    for (int i = 0; i < garbage.length; i++) {
      String garbageStr = garbage[i];
      for (Character c : garbageStr.toCharArray()) {
        if (c == 'M') {
          cm++;
          lastm = i;
        }
        if (c == 'P') {
          cp++;
          lastp = i;
        }
        if (c == 'G') {
          cg++;
          lastg = i;
        }
      }
    }
    int ans = cg + cm + cp;
    for (int i = 0; i < travel.length; i++) {
      if (lastg > i)
        ans += travel[i];
      if (lastm > i)
        ans += travel[i];
      if (lastp > i)
        ans += travel[i];
    }
    return ans;
  }
}