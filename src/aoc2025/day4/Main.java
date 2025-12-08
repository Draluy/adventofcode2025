package aoc2025.day4;

import aoc2025.day3.BatteryParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws IOException {

    Stream<String> lines = Files.lines(Paths.get("src/aoc2025/day4/rolls.txt"));
    TPParser bp = new TPParser(lines);
    System.out.println(bp.getNbAccessible());
  }
}
