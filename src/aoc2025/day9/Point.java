package aoc2025.day9;

public record Point(long x, long y) {

  public Point(String l) {
    this(Long.parseLong(l.split(",")[0]), Long.parseLong(l.split(",")[1]));
  }
}
