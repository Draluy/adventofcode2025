package aoc2025.day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;

public class RectangleFinder {

  private Rectangle maxRect = null;

  public RectangleFinder(List<String> lines) {
    List<Point> points = new ArrayList<>(lines.stream().map(Point::new).toList());
    points.add(points.getFirst());
    GeometryFactory gf = new GeometryFactory();
    Coordinate[] ccords = points.stream().map(p -> new Coordinate(p.x(), p.y())).toArray(Coordinate[]::new);
    Polygon polygon = gf.createPolygon(ccords);

    Set<Rectangle> allRectangles = new HashSet<>();

    for (Point p1: points) {
      for (Point p2 : points) {
        Rectangle rectangle = new Rectangle(p1, p2).normalize();
        allRectangles.add(rectangle);
      }
    }

    for (Rectangle rect: allRectangles) {
      Polygon rectPoly = gf.createPolygon(rect.getCoords());
      boolean contained = rectPoly.coveredBy(polygon);

      if(contained) {
        if(maxRect == null || rect.getArea() > maxRect.getArea()) {
          this.maxRect = rect;
        }
      }
    }
  }

  public Rectangle largestRectangle() {
    return maxRect;
  }
}
