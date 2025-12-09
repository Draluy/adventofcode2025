package aoc2025.day9;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class RectangleFinderTest {
  @Test
  void test () {
    String input= """
7,1
11,1
11,7
9,7
9,5
2,5
2,3
7,3
""";
    RectangleFinder rectangleFinder = new RectangleFinder(Arrays.stream(input.split("\n")).toList());
    System.out.println(rectangleFinder.largestRectangle());
    System.out.println(rectangleFinder.largestRectangle().getArea());
  }

}