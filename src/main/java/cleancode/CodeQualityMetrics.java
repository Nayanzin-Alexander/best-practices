package cleancode;

import java.util.stream.Stream;

public class CodeQualityMetrics {

    public static final String[] CODE_QUALITY_METRICS = new String[] {
        "Code quality metrics:",
        " * Code coverage: is a metric for finding untested parts of a codebase.",
        " * CBO (Coupling between objects): represents the number of classes coupled to a given class.",
        " * LOCM (Lack of cohesion methods): connection between methods and fields.",
        " * Cyclomatic complexity: measures how complex the code is.",
        " * Static code rules: score provided by static code analysis tool.",
        " * Code comments percentage: comments density.",
        " * Technical debt: the cost associated with maintaining and enchancing a platform where "
            + "shortcuts where taken in the design and\\or implementation phase.",
        " * Duplicate code percentage.",
        " * Unit test success percentage"
    };

    public static void main(String[] args) {
        Stream.of(CODE_QUALITY_METRICS).forEachOrdered(System.out::println);
    }
}
