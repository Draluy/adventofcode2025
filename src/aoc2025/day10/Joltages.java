package aoc2025.day10;

import java.util.Arrays;
import java.util.Objects;

public record Joltages(int[] joltages) {

public int diff(Joltages j) {
    return Math.abs(Arrays.stream(joltages).sum() - Arrays.stream(j.joltages).sum());
}

    @Override
    public String toString() {
        return Arrays.toString(joltages);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Joltages joltages1 = (Joltages) o;
        return Objects.deepEquals(joltages, joltages1.joltages);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(joltages);
    }

    public Joltages(int[] joltages) {
        this.joltages = Arrays.copyOf(joltages, joltages.length);
    }

    public static Joltages allZeroes(int size) {
        int[] a = new int[size];
        Arrays.fill(a, 0);
        return new Joltages(a);
    }

    int get(int i) {
        return joltages[i];
    }

    public boolean greater(Joltages j) {
        for (int i = 0; i < joltages.length; i++) {
            if (j.get(i) < joltages[i]) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return joltages.length;
    }

    public Joltages applyButton(Button button) {
        Joltages newJoltage = new Joltages(joltages);

        for (Integer i : button.lightsChanged()) {
            newJoltage.increase(i);
        }
        return newJoltage;
    }

    private void increase(Integer i) {
        joltages[i] = ++joltages[i];
    }
}
