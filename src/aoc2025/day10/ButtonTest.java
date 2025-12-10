package aoc2025.day10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ButtonTest {

    @Test
    void getBitMask() {
        Button button = new Button("3",4);
        assertEquals(1, button.bitMask());

        Button button2 = new Button("1,3",4);
        assertEquals(5, button2.bitMask());

        Button button3 = new Button("2",4);
        assertEquals(2, button3.bitMask());

        Button button4 = new Button("0,1",4);
        assertEquals(12, button4.bitMask());
    }
}