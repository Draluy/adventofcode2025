package aoc2025.day5;

import aoc2025.day4.TPParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws IOException {

    Stream<String> lines = Files.lines(Paths.get("src/aoc2025/day5/ids.txt"));
    IngredientsParser bp = new IngredientsParser(lines);

    System.out.println(bp.nbFresh());
    System.out.println(bp.nbIdsFresh());
  }
}
