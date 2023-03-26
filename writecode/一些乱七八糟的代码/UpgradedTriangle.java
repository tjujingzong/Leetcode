public class Triangle {
  public static enum Type {
    INVALID, SCALENE, EQUILATERAL, ISOSCELES
  };

  public static Type classify(int a, int b, int c) {
    if (a <= 0 || b <= 0 || c <= 0) {
      return Type.INVALID;
    }
    if (a + b <= c || a + c <= b || b + c <= a) {
      return Type.INVALID;
    }
    if (a == b && b == c) {
      return Type.EQUILATERAL;
    }
    if (a == b || b == c || a == c) {
      return Type.ISOSCELES;
    }
    return Type.SCALENE;
  }

  public static double area(int a, int b, int c) {
    if (classify(a, b, c) == Type.INVALID)
      return 0;
    double p = (a + b + c) / 2.0;
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
  }

  public double Calc(int a, int b, double c) {
    double d = 0;
    if (a > 0 && b > 0) {
      c = c / a;
    }
    if (a > 1 || c > 1) {
      c = c + 1;
    }
    d = b + c;
    return d;
  }

  public static int patternIndex(String subject, String pattern) {
    final int NOTFOUND = -1;
    int iSub = 0, rtnIndex = NOTFOUND;
    boolean isPat = false;
    int subjectLen = subject.length();
    int patternLen = pattern.length();
    while (isPat == false && iSub + patternLen - 1 < subjectLen) {
      if (subject.charAt(iSub) == pattern.charAt(0)) {
        rtnIndex = iSub; // Starting at zero
        isPat = true;
        for (int iPat = 1; iPat < patternLen; iPat++) {
          if (subject.charAt(iSub + iPat) != pattern.charAt(iPat)) {
            rtnIndex = NOTFOUND;
            isPat = false;
            break;// out of for loop)
          }
        }
      }
      iSub++;
    }
    return (rtnIndex);
  }
}