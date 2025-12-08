package aoc2025.day8;

import java.util.*;

public class Circuit {
    private final List<Point3D> positions = new LinkedList<>();
    private final Set<Connection> connections = new HashSet<>();

    public void addConnection(Point3D point1, Point3D point2) {
        connections.add(new Connection(point1, point2).normalized());
    }

    public Set<Connection> getConnections() {
        return connections;
    }

    public void addConnections(Set<Connection> connections) {
        this.connections.addAll(connections);
    }

    public boolean areConnected(Point3D position1, Point3D position2) {
        Connection pair = new Connection(position1, position2).normalized();
        return connections.contains(pair);
    }

    private record Connection(Point3D p1, Point3D p2) {
        public Connection normalized() {
            return p1.x()+p1.y()+p1.z() <= p2.x()+p2.y()+p2.z() ? this : new Connection(p2, p1);
        }
    }

    public Circuit(Point3D p) {
        positions.add(p);
    }

    public Circuit() {

    }

    void add(Point3D... points) {
        Collections.addAll(positions, points);
    }

    public List<Point3D> getPositions() {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circuit circuit = (Circuit) o;
        return Objects.equals(positions, circuit.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(positions);
    }
}
