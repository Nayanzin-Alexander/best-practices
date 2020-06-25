package cleancode;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.Map;

public class CommentingRules {

    public static final String COMPLIANT_COMMENTS =
        "Compliant comments\n"
            + " * Legal comments\n"
            + " * Informative comments. f.e regex explaining\n"
            + " * Explanation of intent\n"
            + " * TODO comments\n"
            + " * Improving the code\n\n";

    public static final String NON_COMPLIANT_COMMENTS =
        "Non compliant comments\n"
            + " * When bad code motivates to write comments:\n"
            + " * Redundant comments\n"
            + " * Commented out the code\n"
            + " * Noise comments\n"
            + " * Incorrect comments\n"
            + " * Journaling comments\n\n";

    public static void main(String[] args) {
        System.out.println(COMPLIANT_COMMENTS);
        System.out.println(NON_COMPLIANT_COMMENTS);
    }
}
