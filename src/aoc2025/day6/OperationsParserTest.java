package aoc2025.day6;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

class OperationsParserTest {
    @Test
    void testParse() {
        String input = """
123 328  51 64\s
 45 64  387 23\s 
  6 98  215 314
*   +   *   +\s\s  
""";
        OperationsParser operationsParser = new OperationsParser(Stream.of(input.split("\n")));

        System.out.println(operationsParser.getGrandTotal());

    }
}