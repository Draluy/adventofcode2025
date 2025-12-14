package aoc2025.day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoltagesTest {

    @Test
    void applyButton() {
        Joltages joltages = new Joltages(new int[4]);
        Joltages result = joltages.applyButton(new Button("1,3", 4));

        assertArrayEquals(new int[]{0, 1, 0, 1}, result.joltages());

        result = result.applyButton(new Button("1,2", 4));

        assertArrayEquals(new int[]{0, 2, 1, 1}, result.joltages());
    }

    @Test
    void equals() {
        Joltages joltages = new Joltages(new int[4]);
        Joltages joltages2 = new Joltages(new int[4]);

        assertTrue(joltages2.equals(joltages));
    }
}