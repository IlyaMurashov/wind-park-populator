package geom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolygonTests {
    private static Point[] TEST_POINTS = {new Point(1.1, 1.1), new Point(-2.2, -2.2),
            new Point(3.3, 3.3), new Point(3.3, 3.3), new Point(-2.2, -2.2)};

    private Polygon testPoly;

    @BeforeEach
    void createNewPolygon() {
        testPoly = new Polygon(TEST_POINTS);
    }

    @Nested
    @DisplayName("Min/max coordinats methods")
    class minMax {

        @Test
        void getMaxX() {
            assertEquals(3.3, testPoly.getMaxX());
        }

        @Test
        void getMinX() {
            assertEquals(-2.2, testPoly.getMinX());
        }

        @Test
        void getMaxY() {
            assertEquals(3.3, testPoly.getMaxY());
        }

        @Test
        void getMinY() {
            assertEquals(-2.2, testPoly.getMinY());
        }
    }
}
