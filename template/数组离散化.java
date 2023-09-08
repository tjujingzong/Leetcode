// 松离散
private void discrete(int[] nums){ 
  int n = nums.length;
  int[] tmp = new int[n];
  System.arraycopy(nums, 0, tmp, 0, n);
  Arrays.sort(tmp);
  for (int i = 0; i < n; ++i) {
      nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
  }
}

// 紧离散
private Map<Integer, Integer> discrete(int[] nums){ 
  Map<Integer, Integer> map = new HashMap<>();
  Set<Integer> set = new HashSet<>();
  for(int num : nums) set.add(num);
  List<Integer> list = new ArrayList<>(set);
  Collections.sort(list);
  int idx = 0;
  for(int num : list) map.put(num, ++idx);
  return map;
}
