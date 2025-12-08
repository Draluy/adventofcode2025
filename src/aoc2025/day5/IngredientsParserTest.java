package aoc2025.day5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class IngredientsParserTest {

  @Test
  void parse() {
    String file = """
3-5
10-14
16-20
12-18

1
5
8
11
17
32
""";
    IngredientsParser ip = new IngredientsParser(Stream.of(file.split("\n")));
    assertEquals(6, ip.getAvailableIds().size());

    assertFalse(ip.isFresh(1));
    assertTrue(ip.isFresh(5));
    assertFalse(ip.isFresh(8));
    assertTrue(ip.isFresh(11));
    assertTrue(ip.isFresh(17));
    assertFalse(ip.isFresh(32));
    
    assertEquals(14, ip.nbIdsFresh());
  }

}