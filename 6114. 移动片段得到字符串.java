class Solution {
  public boolean canChange(String start, String target) {
      if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) return false;
      for (int i = 0, j = 0; i < start.length(); ++i) {
          if (start.charAt(i) == '_') continue;
          while (target.charAt(j) == '_') ++j;
          if (i != j && (start.charAt(i) == 'L') != (i > j)) return false;
          ++j;
      }
      return true;
  }
}

