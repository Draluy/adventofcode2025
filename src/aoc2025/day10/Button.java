package aoc2025.day10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Button {

  Set<Integer> lightsChanged = new HashSet<>();
  public Button(String btns) {
    lightsChanged.addAll(Arrays.stream(btns.split(",")).map(Integer::parseInt).toList());
  }

}
