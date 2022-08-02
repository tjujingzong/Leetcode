class Solution {
  public void duplicateZeros(int[] arr) {
    int[] temp = arr.clone();
    int p = 0;
    int i = 0;
    while (p < arr.length) {
      if (temp[i] == 0) {
        arr[p] = 0;
        p++;
        if (p < arr.length)
          arr[p] = 0;
      } else
        arr[p] = temp[i];
      p++;
      i++;
    }
  }
}