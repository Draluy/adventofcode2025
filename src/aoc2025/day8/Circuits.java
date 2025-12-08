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

        for (Circuit circuit1 : circuits) {
            for (Point3D position1 : circuit1.getPositions()) {
                for (Circuit circuit2 : circuits) {
                    for (Point3D position2 : circuit2.getPositions()) {
                        if(position1.equals(position2) || circuit1.areConnected(position1, position2)) {
                            continue;
                        }

                        double distance = position1.distanceSquared(position2);
                        if (distance < minDistance) {
                            minDistance = distance;
                            minPair = new CircuitPair(circuit1, position1, circuit2, position2);
                        }
                    }
                }
            }
        }
        return minPair;
    }

    public void mergeCircuits(CircuitPair closest) {
        if(closest.first().equals(closest.second())) {
            closest.first().addConnection(closest.firstPosition(), closest.secondPosition());
            return;
        }

        circuits.remove(closest.first());
        circuits.remove(closest.second());

        Circuit circuit = new Circuit();
        circuit.add(closest.first().getPositions().toArray(new Point3D[0]));
        circuit.add(closest.second().getPositions().toArray(new Point3D[0]));

        circuit.addConnections(closest.first().getConnections());
        circuit.addConnections(closest.second().getConnections());

        circuit.addConnection(closest.firstPosition(), closest.secondPosition());

        circuits.add(circuit);
    }

    public long getNbCircuits(){
        return circuits.size();
    }
}
