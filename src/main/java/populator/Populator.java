package populator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import geom.Line;
import geom.Point;
import geom.Polygon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Populator {
    private static final ObjectMapper mapper = new ObjectMapper();

    private final Polygon polygon;
    private final int nPoints;

    private final String output;

    public Populator(String inputString) {
        ObjectNode inputTree = null;
        try {
            inputTree = (ObjectNode) mapper.readTree(inputString);
        }
        catch (JsonParseException notJson) {
            System.err.println("WF populator: Input String is not a JSON object");
        }
        catch (IOException e) {
            System.err.println("WF populator: Error reading the input");
            e.printStackTrace();
        }

        ArrayNode polygonArrayNode = (ArrayNode) inputTree.get("polygon");
        if (polygonArrayNode == null)
            throw new RuntimeException("WF populator: no wind farm boundary provided");
        if (polygonArrayNode.size() < 3)
            throw new RuntimeException("WF populator: wind farm boundary must contain at least"
                    + " three points");

        nPoints = inputTree.get("nPoints").asInt();

        List<Point> points = new ArrayList<>();
        for (JsonNode point : polygonArrayNode) {
            points.add(new Point(point.get("long").asDouble(), point.get("lat").asDouble()));
        }

        polygon = new Polygon(points.toArray(new Point[points.size()]));

        points.forEach((p) -> System.out.println(p.getX()+", " + p.getY()));
        Line[] temp = polygon.getLines();

        for (Line line : temp) {
            System.out.println(line);
        }

    }

    public String getPointsDistribution() {
        if (output != null) return output;


    }
}
