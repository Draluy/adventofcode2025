package aoc2025.day5;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class IngredientsParser {

  Pattern rangePattern = Pattern.compile("(?<start>\\d+)-(?<end>\\d+)");
  List<Long> availableIds = new LinkedList<>();
  List<Range> sortedRanges = new ArrayList<>();

  private record Range(long start, long end) {
    public boolean isInRange(long l){
      return  start <= l && l <= end;
    }
  }

  public IngredientsParser(Stream<String> lines) {
    Iterator<String> lineIterator = lines.iterator();

    String currLine = null;

    // Parse valid ids
    while (lineIterator.hasNext() && !(currLine = lineIterator.next()).equals("\n")) {
      Matcher matcher = rangePattern.matcher(currLine);
      if(!matcher.find()) {
        break;
      }
      long rangeStart = Long.parseLong(matcher.group("start"));
      long rangeEnd = Long.parseLong(matcher.group("end"));
      sortedRanges.add(new Range(rangeStart, rangeEnd));
    }

    // Parse available ids
    while (lineIterator.hasNext() && !(currLine = lineIterator.next()).equals("\n")) {
        availableIds.add(Long.parseLong(currLine));
    }

    // Fix ranges so they dont overlap
    sortedRanges.sort(Comparator.comparingLong(r -> r.start));

    long maxRange=0;
    for (int i =0; i<sortedRanges.size(); i++) {
      //if start range is below a previous range, fix its start
      Range range = sortedRanges.get(i);
      if (range.start <= maxRange) {
        Range newRange = new Range(maxRange + 1, range.end);
        sortedRanges.set(i , newRange);
      }
      maxRange = Math.max(maxRange, range.end);
    }
    // remove lopsided ranges
    sortedRanges.removeIf(r -> r.end < r.start);
  }

  public List<Long> getAvailableIds() {
    return availableIds;
  }

  public boolean isFresh(long i) {
    return sortedRanges.stream().anyMatch(r -> r.isInRange(i));
  }

  public long nbFresh() {
    return availableIds.stream().filter(this::isFresh).count();
  }

  public long nbIdsFresh(){
    return sortedRanges.stream().mapToLong(
        r -> r.end - r.start + 1
    ).sum();
  }
}
