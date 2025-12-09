package aoc2025.day9;


import org.locationtech.jts.geom.Coordinate;

public record Rectangle(Point p1, Point p2) {

  public long getArea() {
    long width = Math.abs(p1.x() - p2.x()) + 1;
    long height = Math.abs(p1.y() - p2.y()) + 1;

    return height * width;

  }

  public Rectangle normalize() {
    // compute corners
    long minX = Math.min(p1.x(),  p2.x());
    long maxX = Math.max(p1.x(),  p2.x());
    long minY = Math.min(p1.y(), p2.y());
    long maxY = Math.max(p1.y(), p2.y());

    Rectangle norm = new Rectangle(new Point(minX, minY), new Point(maxX, maxY));

    if(norm.equals(this)) return this;

    return norm;
  }

  public Coordinate[] getCoords() {

    return new Coordinate[]{
        new Coordinate(p1.x(),  p1.y()),
        new Coordinate(p2.x(),  p1.y()),
        new Coordinate(p2.x(),  p2.y()),
        new Coordinate(p1.x(),  p2.y()),
        new Coordinate(p1.x(),  p1.y())  // close polygon
    };
  }

}
