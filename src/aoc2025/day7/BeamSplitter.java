package aoc2025.day7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeamSplitter {
    private final char[][] diagram;
    private final int height;
    private final int width;
    Map<String, Long> memo = new HashMap<>();

    public BeamSplitter(List<String> lines) {
        this.height = lines.size();
        this.width = lines.getFirst().length();
        diagram = new char[width][height];
        loadDiagram(lines);

        System.out.println("leafs = "+travel(lines.getFirst().indexOf('S'), 1));
    }

    long travel(int i, int j) {
        String key = i + "," + j;
        if (memo.containsKey(key))
            return memo.get(key);

        long nbLeafs = 0;
        if (j == height-1) {
            // we are at the bottom
            nbLeafs++;
            return nbLeafs;
        }

        char curr = diagram[i][j];

        if (curr == '.') {
            nbLeafs = travel(i, j + 1);
        }
        if (curr == '^') {
            // we splitting!
            nbLeafs += travel(i - 1, j);
            nbLeafs += travel(i + 1, j);
        }

        memo.put(key, nbLeafs);
        return nbLeafs;
    }

    private void loadDiagram(List<String> lines) {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                diagram[i][j] = lines.get(j).charAt(i);
            }
        }
    }
}
