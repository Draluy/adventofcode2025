package aoc2025.day8;

import java.util.ArrayList;
import java.util.List;

public class PositionParser {

  List<Point3D> allPositions = new ArrayList<>();
  Circuits circuits = new Circuits();

  public PositionParser(List<String> positions) {
    this.allPositions.addAll(positions.stream().map(Point3D::new).toList());

    // create a circuit per position
    for (Point3D p : allPositions) {
      circuits.add(new Circuit(p));
    }

    for (int i = 0; i < 10; i++) {
      CircuitPair closest = circuits.findClosest();
      circuits.mergeCircuits(closest);
    }

  }



  public long getResult() {
    // Get three largest
    return circuits.getResult();
  }
}
