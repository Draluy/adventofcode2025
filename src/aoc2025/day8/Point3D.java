package aoc2025.day8;

public record Point3D(int x, int y , int z) {

  public Point3D(String positionStr) {
    this(Integer.parseInt(positionStr.split(",")[0]),
    Integer.parseInt(positionStr.split(",")[1]),
    Integer.parseInt(positionStr.split(",")[2]));
  }

  double distanceSquared(Point3D b) {
    double dx = this.x() - b.x();
    double dy = this.y() - b.y();
    double dz = this.z() - b.z();
    return dx*dx + dy*dy + dz*dz;
  }
}
