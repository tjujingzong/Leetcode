class Solution {
  public long distinctNames(String[] ideas) {
    int n = ideas.length;
    long ans = 0;

    HashMap<Integer, Set<String>> map = new HashMap<>();
    for (String s : ideas) {
      int ch = s.charAt(0) - 'a';
      if (map.containsKey(ch)) {
        Set<String> set = map.get(ch);
        set.add(s.substring(1));
      } else {
        Set<String> set = new HashSet<>();
        set.add(s.substring(1));
        map.put(ch, set);
      }
    }

    for (int i = 0; i < 26; i++) {
      if (!map.containsKey(i)) {
        continue;
      }
      for (int j = i + 1; j < 26; j++) {
        if (!map.containsKey(j)) {
          continue;
        }
        Set<String> seti = map.get(i);
        Set<String> setj = map.get(j);

        int cnt = 0;
        Iterator<String> iterator = seti.iterator();
        while (iterator.hasNext()) {
          if (setj.contains(iterator.next())) {
            cnt++;
          }
        }
        ans += (seti.size() - cnt) * (setj.size() - cnt) * 2;
      }
    }

    return ans;
  }
}