package aoc2025.day2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RangeParser {

  Pattern pattern = Pattern.compile("(?<start>\\d+)-(?<end>\\d+)");
  List<Range> ranges = new LinkedList<>();

  public RangeParser(String ranges) {
    Matcher matcher = pattern.matcher(ranges);
    while (matcher.find()) {
      String start = matcher.group("start");
      String end = matcher.group("end");
      Range range = new Range(Long.parseLong(start), Long.parseLong(end));
      this.ranges.add(range);
    }
    this.ranges.sort(Comparator.comparingLong(Range::start));
  }

  public List<Range> ranges() {
    return ranges;
  }
}
