package aoc2025.day10;

import java.util.*;

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
        return ""+Integer.toBinaryString(bitMask);
    }

    public boolean affectsAnyRemainingLight(Joltages state, Joltages targetJoltages) {
        Set<Integer> remainingvalues = new HashSet<>();
        for (int i = 0; i < state.size(); i++) {
            if (state.get(i) != targetJoltages.get(i)) {
                remainingvalues.add(i);
            }
        }

        return remainingvalues.containsAll(this.lightsChanged());
    }
}
