public class TestSuite extends TestCase {
  public void test1() {
    assertEquals(triangle.Triangle.area(0, 1301, 1), 0, 0.01);
  }

  public void test2() {
    assertEquals(triangle.Triangle.area(1108, 1, 1), 0, 0.01);
  }

  public void test3() {
    assertEquals(triangle.Triangle.area(1, 0, -665), 0, 0.01);
  }

  public void test4() {
    assertEquals(triangle.Triangle.area(1, 1, 0), 0, 0.01);
  }

  public void test5() {
    assertEquals(triangle.Triangle.area(582, 582, 582), 146671.79, 0.01);
  }

  public void test6() {
    assertEquals(triangle.Triangle.area(1, 1088, 15), 0, 0.00);
  }

  public void test7() {
    assertEquals(triangle.Triangle.area(1, 2, 450), 0, 0.00);
  }

  public void test8() {
    assertEquals(triangle.Triangle.area(1663, 1088, 823), 386411.66, 0.01);
  }

  public void test9() {
    assertEquals(triangle.Triangle.area(1187, 1146, 1), 0, 0.00);
  }

  public void test10() {
    assertEquals(triangle.Triangle.area(1640, 1640, 1956), 1287516.10, 0.01);
  }

  public void test11() {
    assertEquals(triangle.Triangle.area(784, 784, 1956), 0, 0.00);
  }

  public void test12() {
    assertEquals(triangle.Triangle.area(1, 450, 1), 0, 0.00);
  }

  public void test13() {
    assertEquals(triangle.Triangle.area(1146, 1, 1146), 572.99, 0.01);
  }

  public void test14() {
    assertEquals(triangle.Triangle.area(1640, 1956, 1956), 1456172.24, 0.01);
  }

  public void test15() {
    assertEquals(triangle.Triangle.area(-1, 1, 1), 0, 0.01);
  }

  public void test16() {
    assertEquals(triangle.Triangle.classify(0, 1301, 1), INVALID);
  }

  public void test17() {
    assertEquals(triangle.Triangle.classify(1108, 1, 1), INVALID);
  }

  public void test18() {
    assertEquals(triangle.Triangle.classify(1, 0, -665), INVALID);
  }

  public void test19() {
    assertEquals(triangle.Triangle.classify(1, 1, 0), INVALID);
  }

  public void test20() {
    assertEquals(triangle.Triangle.classify(582, 582, 582), EQUILATERAL);
  }

  public void test21() {
    assertEquals(triangle.Triangle.classify(1, 1088, 15), INVALID);
  }

  public void test22() {
    assertEquals(triangle.Triangle.classify(1, 2, 450), INVALID);
  }

  public void test23() {
    assertEquals(triangle.Triangle.classify(1663, 1088, 823), SCALENE);
  }

  public void test24() {
    assertEquals(triangle.Triangle.classify(1187, 1146, 1), INVALID);
  }

  public void test25() {
    assertEquals(triangle.Triangle.classify(1640, 1640, 1956), ISOSCELES);
  }

  public void test26() {
    assertEquals(triangle.Triangle.classify(784, 784, 1956), INVALID);
  }

  public void test27() {
    assertEquals(triangle.Triangle.classify(1, 450, 1), INVALID);
  }

  public void test28() {
    assertEquals(triangle.Triangle.classify(1146, 1, 1146), ISOSCELES);
  }

  public void test29() {
    assertEquals(triangle.Triangle.classify(1640, 1956, 1956), ISOSCELES);
  }

  public void test30() {
    assertEquals(triangle.Triangle.classify(-1, 1, 1), INVALID);
  }
}