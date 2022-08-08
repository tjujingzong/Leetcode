import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashMap<String, Integer> map = new HashMap<>();// string->step
    HashSet<String> wordset = new HashSet<>(wordList);
    if (!wordset.contains(endWord))
      return 0;
    Queue<String> q = new ArrayDeque<>();
    q.add(beginWord);
    map.put(beginWord, 0);
    wordset.remove(beginWord);
    while (!q.isEmpty()) {
      String top = q.poll();
      int step = map.get(top);
      if (top.equals(endWord))
        break;
      for (String word : wordset) {
        if (matched(word, top)) {
          q.add(word);
          map.put(word, step + 1);
        }
      }
      wordset.removeAll(map.keySet());
    }
    if (!map.keySet().contains(endWord))
      return 0;
    int len = map.get(endWord);
    return len + 1;
  }

  private boolean matched(String s, String beginWord) {
    int num = 0;
    for (int i = 0; i < s.length(); i++)
      if (s.charAt(i) != beginWord.charAt(i))
        num++;
    if (num == 1)
      return true;
    return false;
  }

}
// @lc code=end
