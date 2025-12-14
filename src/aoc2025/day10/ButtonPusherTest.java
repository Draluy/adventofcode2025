package aoc2025.day10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class ButtonPusherTest {

    @ParameterizedTest
    @CsvSource(value = {
            "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7};2",
            "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2};3",
            "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5};2"}, delimiter = ';')
    void testPart1(String input, int presses) {
        ButtonPusher bp = new ButtonPusher(List.of(input));
        bp.part1();
        assertEquals(presses, bp.fewerPushes());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7};10",
            "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2};12",
            "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5};11"}, delimiter = ';')
    void testPart2(String input, int presses) {
        ButtonPusher bp = new ButtonPusher(List.of(input));
        bp.part2();
        assertEquals(presses, bp.fewerPushes());
    }

    @Test
    void simpleTestPart2() {
        String text = """
                [.##.] (3) (1,3) (2,3) (0,2) (0,1) {3,5,4,7}
                """;
        ButtonPusher bp = new ButtonPusher(text.lines().toList());
        bp.part2();
        assertEquals(10, bp.fewerPushes());
    }
    @Test
    void longerTestPart2() {
        String text = """
                [#..#.#.#.] (1,3) (1,8) (0,6,7,8) (0,2,3,7,8) (1,2,4,5,6) (0,2,3,5,6,7,8) (1,2,3,5,6,7,8) {41,41,44,60,4,28,36,48,58}
                """;
        ButtonPusher bp = new ButtonPusher(text.lines().toList());
        bp.part2();
        assertEquals(10, bp.fewerPushes());
    }

    @Test
    void simpleTestPart1() {
        String text = """
                [.##.] (2) (0,2) (0,1) {3,5,4,7}
                """;
        ButtonPusher bp = new ButtonPusher(text.lines().toList());
        bp.part1();
        assertEquals(2, bp.fewerPushes());
    }


}