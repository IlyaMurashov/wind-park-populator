package geom;

import java.util.Comparator;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

//    public static Comparator<Point> byX = (p1, p2) -> {
//        if (p1.getX() > p2.getX()) return 1;
//        if (p1.getX() < p2.getX()) return -1;
//        return 0;
//    };
//
//    public static Comparator<Point> byY = (p1, p2) -> {
//        if (p1.getY() > p2.getY()) return 1;
//        if (p1.getY() < p2.getY()) return -1;
//        return 0;
//    };

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
