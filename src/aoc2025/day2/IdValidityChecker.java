package aoc2025.day2;

import java.util.regex.Pattern;

public record IdValidityChecker() {

  static Pattern invalid = Pattern.compile("^(\\d+)\\1+$");

  public boolean isValid(Long value) {
    String str = String.valueOf(value);
    return !invalid.matcher(str).matches();
  }

}
