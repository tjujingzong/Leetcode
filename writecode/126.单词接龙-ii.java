
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
class Solution {
  HashMap<String, Integer> map = new HashMap<>();// string->step
  List<List<String>> ans = new ArrayList<>();

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> wordset = new HashSet<>(wordList);
    if (!wordset.contains(endWord))
      return new ArrayList<>();
    Queue<String> q = new ArrayDeque<>();
    q.add(beginWord);
    map.put(beginWord, 0);
    wordset.remove(beginWord);
    while (!q.isEmpty()) {
      String top = q.poll();
      int step = map.get(top);
      if (top.equals(endWord))
        break;
      HashSet<String> temp = new HashSet<>();
      temp.addAll(wordset);
      for (String word : wordset) {
        if (matched(word, top)) {
          temp.remove(word);
          q.add(word);
          map.put(word, step + 1);
        }
      }
      wordset = temp;
    }
    if (!map.keySet().contains(endWord))
      return ans;
    TreeMap<Integer, HashSet<String>> treeMap = new TreeMap<>();// 按step大小分成不同集合
    int len = map.get(endWord);
    for (int i = 0; i <= len + 2; i++)
      treeMap.put(i, new HashSet<>());
    for (String s : map.keySet()) {
      int step = map.get(s);
      treeMap.get(step).add(s);
    }
    System.out.println(treeMap);
    ArrayList<String> aList = new ArrayList<>();
    aList.add(endWord);
    dfs(beginWord, endWord, len, aList, treeMap);
    return ans;
  }

  private void dfs(String beginWord, String thisWord, int len, ArrayList<String> aList,
      TreeMap<Integer, HashSet<String>> treeMap) {
    if (len == 1) {
      aList.add(beginWord);
      Collections.reverse(aList);
      ans.add(aList);
      return;
    }
    for (String s : treeMap.get(len - 1)) {
      if (matched(s, thisWord)) {
        ArrayList<String> newlist = new ArrayList<String>();
        newlist.addAll(aList);
        newlist.add(s);
        dfs(beginWord, s, len - 1, newlist, treeMap);
      }
    }
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
