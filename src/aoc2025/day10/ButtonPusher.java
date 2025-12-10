package aoc2025.day10;

import java.util.List;

public class ButtonPusher {

  public ButtonPusher(List<String> lines) {
    List<Machine> machines = lines.stream().map(Machine::new).toList();
  }

  public Integer fewerPushes() {
    return 0;
  }
}
