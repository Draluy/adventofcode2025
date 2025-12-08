package aoc2025.day8;

import java.util.List;

public class PositionParser {

    Circuits circuits = new Circuits();

    public PositionParser(List<String> positions) {
        List<Point3D> allPositions = positions.stream().map(Point3D::new).toList();

        // create a circuit per position
        for (Point3D p : allPositions) {
            circuits.add(new Circuit(p));
        }

         while (circuits.getNbCircuits() > 1) {
        //  for (int i = 0; i < 1000; i++) {

            CircuitPair closest = circuits.findClosest();
            long nbCircuits = circuits.getNbCircuits();
            System.out.println("nbCircuits = " + nbCircuits);
            circuits.mergeCircuits(closest);
            if (circuits.getNbCircuits() == 1) {
                // We are about to merge the two last ones
                System.out.println("Last connection = " + closest);
            }
        }


    }


    public long getResult() {
        // Get three largest
        return circuits.getResult();
    }
}
