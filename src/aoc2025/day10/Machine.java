package aoc2025.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Machine {

  private static final Pattern lightsAndJoltages = Pattern.compile("^\\[(?<lights>[.|#]+)\\].*?\\{(?<joltages>(\\d+\\,?)+)\\}$");
  private static final Pattern buttonsPattern = Pattern.compile("\\((?<btns>[0-9,]+)\\)");
  private final List<Boolean> lights = new ArrayList<>();
  private final List<Integer> joltages = new LinkedList<>();
  private final List<Button> buttons = new LinkedList<>();

  public Machine(String l) {
    Matcher matcher = lightsAndJoltages.matcher(l);
    if (matcher.find()) {
      this.lights.addAll(Arrays.stream(matcher.group("lights").split("")).map("#"::equals).toList());
      this.joltages.addAll(Arrays.stream(matcher.group("joltages").split(",")).map(Integer::parseInt).toList());
    }
    Matcher buttonsMatcher = buttonsPattern.matcher(l);
    while (buttonsMatcher.find()) {
      buttons.add( new Button(buttonsMatcher.group("btns")));
    }
  }
}
