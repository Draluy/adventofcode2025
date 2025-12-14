package aoc2025.day10;

import aoc2025.day9.RectangleFinder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {

    List<String> lines = Files.readAllLines(Paths.get("src/aoc2025/day10/machines.txt"));
    ButtonPusher bp = new ButtonPusher(lines);
    bp.part2();
    System.out.println(bp.fewerPushes());
  }
}
