package aoc2025.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    Dial dial = new Dial();
    List<String> lines  = Files.readAllLines( Path.of("./src/aoc2025/day1/input.txt"));
    //List<String> lines  = List.of("L60", "L60", "L60");
    lines.forEach(dial::move);

  }
}
