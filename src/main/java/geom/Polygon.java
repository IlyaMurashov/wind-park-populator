package geom;

import java.util.*;
import java.util.stream.Stream;

public class Polygon {
    private final Point[] points;
    private final Line[] lines;

    public Polygon(Point... points) {
        this.points = points;

        ArrayList<Line> tempLines = new ArrayList<>();
        tempLines.addAll(getLinesBetweenFirstThroughLastPoints());
        tempLines.add(getLineBetweenLastAndFirstPoints());

        lines = tempLines.toArray(new Line[tempLines.size()]);
    }

    private List<Line> getLinesBetweenFirstThroughLastPoints() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < (points.length - 1); i++) {
            lines.add(new Line(points[i], points[i + 1]));
        }

        return lines;
    }

    private Line getLineBetweenLastAndFirstPoints() {
        return new Line(points[points.length - 1], points[0]);
    }

    public double getMinX() {
        Optional<Double> minX = Stream.of(points).map(Point::getX).min(Comparator.naturalOrder());

        if (minX.isPresent()) return minX.get();
        else throw new RuntimeException("Error evaluating min X of the polygon");
    }

    public double getMaxX() {
        Optional<Double> maxX = Stream.of(points).map(Point::getX).max(Comparator.naturalOrder());

        if (maxX.isPresent()) return maxX.get();
        else throw new RuntimeException("Error evaluating max X of the polygon");
    }

    public double getMinY() {
        Optional<Double> minY = Stream.of(points).map(Point::getY).min(Comparator.naturalOrder());

        if (minY.isPresent()) return minY.get();
        else throw new RuntimeException("Error evaluating min Y of the polygon");
    }

    public double getMaxY() {
        Optional<Double> maxY = Stream.of(points).map(Point::getY).max(Comparator.naturalOrder());

        if (maxY.isPresent()) return maxY.get();
        else throw new RuntimeException("Error evaluating max Y of the polygon");
    }

    public Line[] getLines() {
        return lines;
    }

    public Point[] getPoints() {
        return points;
    }

    public int getNumberOfLines() {
        return lines.length;
    }
}
