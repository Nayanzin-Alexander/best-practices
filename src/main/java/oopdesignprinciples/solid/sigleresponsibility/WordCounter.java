package oopdesignprinciples.solid.sigleresponsibility;

import java.util.Map;

public interface WordCounter {
    Map<String, Integer> countWords(String text);
}
