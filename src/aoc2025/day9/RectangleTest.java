package aoc2025.day9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTest {

  @Test
  void getArea() {
    Rectangle r1 = new Rectangle(new Point(1, 1), new Point(2, 2));
    Rectangle r2 = new Rectangle(new Point(1, 1), new Point(2, 1));

    Rectangle r3 = new Rectangle(new Point(2, 2), new Point(1, 1));
    Rectangle r4 = new Rectangle(new Point(2, 1), new Point(1, 1));

    assertEquals(4, r1.getArea());
    assertEquals(4, r3.getArea());
    assertEquals(2, r2.getArea());
    assertEquals(2, r4.getArea());
  }

  @Test
  void normalize() {
    Rectangle r1 = new Rectangle(new Point(1, 1), new Point(2, 2)).normalize();
    Rectangle r2 = new Rectangle(new Point(1, 1), new Point(2, 1)).normalize();

    Rectangle r3 = new Rectangle(new Point(2, 2), new Point(1, 1)).normalize();
    Rectangle r4 = new Rectangle(new Point(2, 1), new Point(1, 1)).normalize();

    assertEquals(r1, r3);
    assertEquals(r2, r4);
  }
}