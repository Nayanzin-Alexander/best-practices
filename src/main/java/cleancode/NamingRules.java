package cleancode;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.Map;

public class NamingRules {

    // Long and explanatory name of the top level variables
    private Map<String, Integer> wordsWithNumberOfOccurrences = new HashMap<>();

    // Short names of the top level methods with broad scope of actions
    public void analyze(String text) {
        filterBadWordsFrom(text);
        wordsWithNumberOfOccurrences = countNumberOfWordsOccurrencesIn(text);
    }

    // Long and explanatory name for low level methods
    private void filterBadWordsFrom(String text) {
        return;
    }

    private Map<String, Integer> countNumberOfWordsOccurrencesIn(String text) {
        Map<String, Integer> collector = new HashMap<>();

        // w - short name for low level variables with narrow scope
        for(String w : text.split("\\W")) {
            collector.compute(w, (k, v) -> isNull(v) ? 1 : ++v);
        }
        return collector;
    }
}
