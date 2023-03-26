import java.util.Arrays;
import java.util.TreeSet;

class Solution {
  public boolean primeSubOperation(int[] nums) {
    TreeSet<Integer> set = new TreeSet<>();
    // 向set中添加小于1000的质数
    for (int i = 2; i < 1000; i++) {
      if (isPrime(i)) {
        set.add(i);
      }
    }
    for (int i = nums.length - 1; i > 0; i--) {
      if (nums[i - 1] >= nums[i]) {
        for (int p : set) {
          if (p >= nums[i - 1])
            break;
          if (nums[i - 1] - p < nums[i]) {
            nums[i - 1] -= p;
            break;
          }
        }
      }
      if (nums[i - 1] >= nums[i]) {
        return false;
      }
    }
    System.out.println(Arrays.toString(nums));
    return true;
  }

  // 判断一个数是否为质数
  private boolean isPrime(int num) {
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}