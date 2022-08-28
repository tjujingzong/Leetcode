class Solution {
  private final static int[] TABLE = {
      9,
      9 * 8,
      9 * 8 * 7,
      9 * 8 * 7 * 6,
      9 * 8 * 7 * 6 * 5,
      9 * 8 * 7 * 6 * 5 * 4,
      9 * 8 * 7 * 6 * 5 * 4 * 3,
      9 * 8 * 7 * 6 * 5 * 4 * 3 * 2,
      9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1,
  };

  public int countSpecialNumbers(int n) {
    int[] nums = parseArr(n);
    // 数位长度
    int len = nums.length;
    // 标记0~9是否使用
    boolean[] visited = new boolean[10];
    // 用于返回的统计结果
    int ans = 0;
    // 假设原数为4位数，那么所有的1、2、3位数都符合要求
    // 4位数要单独拿出来讨论
    ans += totalCountByLen(len - 1);

    for (int i = 0; i < len; i++) {
      int num = nums[i];
      // 假设第一位为4
      // 那么3XXX、2XXX、1XXX都符合要求，注意0XXX要排除
      int cnt = countLessThanMax(visited, num);
      if (i == 0) {
        // 首位数排除0
        --cnt;
      }

      // 当前剩下的数，统计有几种排列组合
      int restTotal = cnt;
      int rest = countLessThanMax(visited, 10) - 1;
      for (int j = i + 1; j < len; j++) {
        restTotal *= rest--;
      }

      ans += restTotal;

      if (visited[num]) {
        // 该数字在前面已被使用，无需再往后判断
        // 比如num = 22225，已通过固定第一位的2，计算了20XXX和21XXX的所有可能性，无需再固定前两位做后续计算
        break;
      }
      visited[num] = true;
    }

    // 因为上面的计算方式会排除掉该数本身，所以对该数字本身是否特殊再做一次判断
    if (isSpecial(nums)) {
      ++ans;
    }

    return ans;
  }

  /**
   * 统计有几个1位数+2位数+...+len位数
   */
  private int totalCountByLen(int len) {
    if (len == 0) {
      return 0;
    }
    // 1位数有9个（排除0）
    int sum = 9;

    for (int i = 0; i < len - 1; i++) {
      // 2位数有9 * 9 = 81个
      // 3位数有9 * 9*8 = 648个
      // 4位数有9 * 9*8*7 = 4536个
      // 累加起来
      sum += 9 * TABLE[i];
    }

    return sum;
  }

  /**
   * 判断这个数本身是否特殊
   */
  private boolean isSpecial(int[] nums) {
    boolean[] visited = new boolean[10];
    for (int num : nums) {
      if (visited[num]) {
        return false;
      }
      visited[num] = true;
    }
    return true;
  }

  /**
   * 找出还有几个未使用的且 < max的数
   */
  private int countLessThanMax(boolean[] visited, int max) {
    int cnt = 0;
    for (int i = 0; i < max; i++) {
      if (!visited[i]) {
        ++cnt;
      }
    }
    return cnt;
  }

  /**
   * 数字转数组，便于后续计算
   */
  private int[] parseArr(int num) {
    char[] chars = String.valueOf(num).toCharArray();
    int len = chars.length;
    int[] arr = new int[len];

    for (int i = 0; i < len; i++) {
      arr[i] = chars[i] - '0';
    }
    return arr;
  }
}

// 作者：peterqiu-007
// 链接：https://leetcode.cn/problems/count-special-integers/solution/6151-tong-ji-te-shu-zheng-shu-po-su-de-m-yty1/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。