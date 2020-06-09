package solid.sigleresponsibility;

import java.util.Map;

public interface ResultWriter {
    String saveResult(String filename, Map<String, Integer> worldCounts);
}
