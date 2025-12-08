package aoc2025.day8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Circuits {
  List<Circuit> circuits = new ArrayList<>();

  public long getResult() {
    // Get three largest
    circuits.sort(Comparator.comparing(Circuit::size));
    circuits = circuits.reversed();
    return circuits.get(0).size() * circuits.get(1).size() * circuits.get(2).size();
  }

  public void add(Circuit circuit) {
    circuits.add(circuit);
  }

  public CircuitPair findClosest() {
    double minDistance = Float.MAX_VALUE;
    CircuitPair minPair = null;
    for (int i = 0; i <circuits.size(); i++) {
      for (int j = 0; j < circuits.size(); j++) {
        if (i == j) {
          continue;
        }
        CircuitPair newPair = new CircuitPair(circuits.get(i), circuits.get(j));
        double distanceSqrt = newPair.minDistanceSquared();
        if(distanceSqrt < minDistance) {
          minDistance = distanceSqrt;
          minPair= newPair;
        }

      }
    }
    return minPair;
  }

  public void mergeCircuits(CircuitPair closest) {
    circuits.remove(closest.first());
    circuits.remove(closest.second());

    Circuit circuit = new Circuit();
    circuit.add(closest.first().getPositions().toArray(new Point3D[0]));
    circuit.add(closest.second().getPositions().toArray(new Point3D[0]));
    circuits.add(circuit);
  }
}
