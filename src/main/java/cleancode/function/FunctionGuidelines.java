package cleancode.function;

public class FunctionGuidelines {

    public static final String FUNCTIONS_BEST_PRACTISES =
        "\n\nFunction best practises\n"
            + "Functions should:\n"
            + " * Hardly be 20 lines long\n"
            + " * Only do one thing\n"
            + " * Have one level of abstraction. \"The step down rule.\"\n"
            + " * Be a command or a query - not both\n"
            + " * Have descriptive names\n"
            + " * Not have side effects\n"
            + " * Use exceptions, not error codes\n"
            + " * Extract try/catch blocks into functions on their own. Error handling counts as \"one thing\"";

    public static final String FUNCTION_ASSESSMENT_QUESTIONS =
        "\n\nFunction assessment questions\n"
        + "1. Is it easy to read?\n"
        + "2. Can you easily navigate the flow of the programm?\n"
        + "3. Does it adhere to the DRY principle?\n"
        + "4. Is it easy to test?\n\n";

    public static void main(String[] args) {
        System.out.println(FUNCTIONS_BEST_PRACTISES);
        System.out.println(FUNCTION_ASSESSMENT_QUESTIONS);
    }
}
