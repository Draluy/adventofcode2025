package aoc2025.day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("src/aoc2025/day6/operations.txt"));
        OperationsParser operationsParser = new OperationsParser(lines);

        System.out.println(operationsParser.getGrandTotal());
    }
}