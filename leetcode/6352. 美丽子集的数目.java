import java.util.Arrays;
import java.util.List;

class Solution {
  int count = 0;

  public int beautifulSubsets(int[] nums, int k) {
    Arrays.sort(nums);
    backtrack(0, nums, k, new ArrayList<Integer>());
    return count;
  }

  private void backtrack(int start, int[] nums, int k, List<Integer> subset) {
    // 如果子集非空，计数器加一
    if (start > 0 && !subset.isEmpty()) {
      count++;
    }

    for (int i = start; i < nums.length; i++) {
      // 检查当前元素是否可以加入子集
      boolean canAdd = true;
      for (int j = subset.size() - 1; j >= 0; j--) {
        if (nums[i] - nums[i] > k)
          break;
        if (nums[i] - subset.get(j) == k) {
          canAdd = false;
          break;
        }
      }

      // 如果可以加入，将当前元素添加到子集，并进行下一步递归
      if (canAdd) {
        subset.add(nums[i]);
        backtrack(i + 1, nums, k, subset);
        subset.remove(subset.size() - 1); // 回溯，移除最后一个元素
      }
    }
  }
}
