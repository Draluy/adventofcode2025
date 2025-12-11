package aoc2025.day10;

import java.util.Arrays;
import java.util.List;

public record Button(List<Integer> lightsChanged, int bitMask) {

    public Button(String btns,  int nbLights) {
        List<Integer> parsed = Arrays.stream(btns.split(","))
                .map(Integer::parseInt)
                .toList();

        this(parsed, getBitMask(parsed, nbLights));
    }

    private static int getBitMask(List<Integer> lightsChanged, int nbLights) {
        int res = 0;
        for (Integer integer : lightsChanged) {
            res |= 1 << (nbLights - integer - 1);
        }
        return res;
    }

    @Override
    public String toString() {
        return ""+lightsChanged;
    }
}
