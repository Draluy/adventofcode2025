package aoc2025.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class BatteryParser {

  private final long maxJoltage;

  public BatteryParser(Stream<String> lines) {

    AtomicLong maxJoltage = new AtomicLong();
    lines.forEachOrdered(line -> {
      List<Integer> joltages = line.chars().map(Character::getNumericValue).boxed().toList();
      maxJoltage.addAndGet(getMaxJoltage(joltages));
    });

    this.maxJoltage = maxJoltage.get();
  }

  public long getMaxJoltage() {
    return maxJoltage;
  }

  private static long getMaxJoltage(List<Integer> joltages) {
    List<Integer> mutJoltages = new ArrayList<>(joltages);
    long value = 0;
    // get the first 4 digts
    for (int i = 0; i < 12; i++) {
      List<Integer> head = mutJoltages.subList(i, i + 89);
      MaxResult maxValue = getMaxValue(head);
      int indexOfMaxValue = maxValue.index + i;

      for (int j = 0; j <= indexOfMaxValue; j++) {
        mutJoltages.set(j, 0);
      }

      value = value * 10 + maxValue.value;
    }

    return value;
  }

  public record MaxResult(int value, int index) {

  }

  private static MaxResult getMaxValue(List<Integer> head) {

    int maxVal = head.getFirst();
    int maxIdx = 0;

    for (int i = 1; i < head.size(); i++) {
      if (head.get(i) > maxVal) {
        maxVal = head.get(i);
        maxIdx = i;
      }
    }

    return new MaxResult(maxVal, maxIdx);

  }
}
