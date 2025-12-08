package aoc2025.day8;

public record CircuitPair(Circuit first, Circuit second) {

  double minDistanceSquared() {
    double minDistance = Double.MAX_VALUE;
    for(Point3D fp: first.getPositions()){
      for (Point3D sp: second.getPositions()){
        double dist = fp.distanceSquared(sp);
        if(dist < minDistance){
          minDistance = dist;
        }
      }
    }
    return minDistance;
  }
}
