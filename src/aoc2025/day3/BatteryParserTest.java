package aoc2025.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BatteryParserTest {


@ParameterizedTest
@CsvSource({"987654321111111,987654321111", "811111111111119,811111111119", "234234234234278,434234234278", "818181911112111,888911112111"})
@CsvSource({ "234234234234278,434234234278"})
  void shoudGetMaxavLue(String line, long res) {
  BatteryParser bp  =  new BatteryParser(Stream.of(line));
  assertEquals(res, bp.getMaxJoltage());
}
}