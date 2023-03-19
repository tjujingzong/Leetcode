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
}