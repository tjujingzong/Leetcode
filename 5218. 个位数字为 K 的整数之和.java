class Solution {
  public int minimumNumbers(int num, int k) {
    if (num == 0)
      return 0;
    int lastnum = num % 10;
    for (int i = 1; i <= 10; i++) {
      if (k * i > num)
        break;
      if ((k * i) % 10 == lastnum)
        return i;
    }
    return -1;
  }
}