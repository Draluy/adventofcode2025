package aoc2025.day4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class TPParserTest {

  private static String lines = """
..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@.
""";

@Test
void testParse() {
  TPParser tpParser = new TPParser(Stream.of(lines.split("\n")));

  assertEquals(13, tpParser.getNbAccessible());
}
}