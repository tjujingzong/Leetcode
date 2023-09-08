import java.util.HashMap;

class Solution {
  public int numRabbits(int[] answers) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < answers.length; i++) {
      if (map.containsKey(answers[i] + 1)) {
        map.compute(answers[i] + 1, (key, value) -> value + 1);
      } else
        map.put(answers[i] + 1, 1);
    }
    int ans = 0;
    for (Integer key : map.keySet()) {
      if (map.get(key) <= key) {
        ans += key;
      } else
        ans += key * (map.get(key) % key == 0 ? map.get(key) / key : map.get(key) / key + 1);
    }
    return ans;
  }
}