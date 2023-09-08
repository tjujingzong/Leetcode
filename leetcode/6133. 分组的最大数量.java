class Solution {
  public int maximumGroups(int[] grades) {
    int n = grades.length;
    int sum = 0;
    int i = 1;
    while (sum <= n) {
      sum += i;
      i++;
    }
    return i - 2;
  }
}