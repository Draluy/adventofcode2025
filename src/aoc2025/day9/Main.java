package aoc2025.day9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {

    List<String> lines = Files.readAllLines(Paths.get("src/aoc2025/day9/points.txt"));
    RectangleFinder bp = new RectangleFinder(lines);

    System.out.println(bp.largestRectangle());
    System.out.println(bp.largestRectangle().getArea());
  }
}
