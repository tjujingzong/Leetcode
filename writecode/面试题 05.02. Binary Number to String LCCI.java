class Solution {
  public String printBin(double num) {
    StringBuilder sb = new StringBuilder();
    sb.append("0.");
    while (num > 0) {
      num *= 2;
      if (num >= 1) {
        sb.append("1");
        num -= 1;
      } else {
        sb.append("0");
      }
      if (sb.length() >= 32) {
        return "ERROR";
      }
    }
    return sb.toString();
  }
}