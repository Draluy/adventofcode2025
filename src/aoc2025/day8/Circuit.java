package aoc2025.day8;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Circuit {
  private Set<Point3D> positions = new HashSet<>();

  public Circuit(Point3D p) {
    positions.add(p);
  }

  public Circuit() {

  }

  void add(Point3D... points) {
    Collections.addAll(positions, points);
  }

  public boolean contains(Point3D point) {
    return positions.contains(point);
  }

  public Set<Point3D> getPositions() {
    return positions;
  }

  public long size() {
    return positions.size();
  }

  @Override
  public String toString() {
    return "Circuit{" +
        "positions=" + positions +
        '}';
  }
}
