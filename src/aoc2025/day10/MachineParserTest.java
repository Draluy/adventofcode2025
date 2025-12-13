package aoc2025.day10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MachineParserTest {
    @ParameterizedTest
    @CsvSource(value = {
            "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7};6",
            "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2};2",
            "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5};29"}, delimiter = ';')
    void parseTarget(String line, int target) {
        assertEquals(target, new MachineParser(line).lights());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7};3,5,4,7",
            "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2};7,5,12,7,2",
            "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5};10,11,11,5,10,5"}, delimiter = ';')
    void parseJoltages(String line, String target) {
        List<Integer> t = Arrays.stream(target.split(",")).map(Integer::parseInt).toList();
        assertEquals(t, new MachineParser(line).joltages());
    }
}