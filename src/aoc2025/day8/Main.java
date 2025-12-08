package aoc2025.day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {

    List<String> lines = Files.readAllLines(Paths.get("src/aoc2025/day8/positions.txt"));
    PositionParser bp = new PositionParser(lines);

    System.out.println(bp.getResult());
  }
}
