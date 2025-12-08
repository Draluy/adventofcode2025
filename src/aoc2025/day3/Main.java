package aoc2025.day3;

import aoc2025.day2.IdValidityChecker;
import aoc2025.day2.Range;
import aoc2025.day2.RangeParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws IOException {

    Stream<String> lines = Files.lines(Paths.get("src/aoc2025/day3/joltages.txt"));
    BatteryParser bp = new BatteryParser(lines);
    System.out.println(bp.getMaxJoltage());
  }
}
