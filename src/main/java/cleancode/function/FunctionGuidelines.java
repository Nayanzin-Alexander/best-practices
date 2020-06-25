package cleancode.function;

public class FunctionGuidelines {

    public static final String FUNCTIONS_BEST_PRACTISES =
        "Function best practises\n"
            + "Functions should:\n"
            + " * Hardly be 20 lines long\n"
            + " * Only do one thing\n"
            + " * Have one level of abstraction. \"The step down rule.\"\n"
            + " * Be a command or a query - not both\n"
            + " * Have descriptive names\n"
            + " * Not have side effects\n"
            + " * Use exceptions, not error codes\n"
            + " * Extract try/catch blocks into functions on their own. Error handling counts as \"one thing\"\n\n";

    public static final String FUNCTION_ASSESSMENT_QUESTIONS =
        "Function assessment questions\n"
            + " * Is it easy to read?\n"
            + " * Can you easily navigate the flow of the programm?\n"
            + " * Does it adhere to the DRY principle?\n"
            + " * Is it easy to test?\n\n";

    public static final String FUNCTION_STRUCTURE_RULES =
        "Function structure rules\n"
            + "The function should:\n"
            + " * have single entrance and exit\n"
            + " * no longer than 100-120 symbols in width\n"
            + " * switch statement can be replaced with polymorphism or a map data structure\n\n";

    public static void main(String[] args) {
        System.out.println(FUNCTIONS_BEST_PRACTISES);
        System.out.println(FUNCTION_ASSESSMENT_QUESTIONS);
        System.out.println(FUNCTION_STRUCTURE_RULES);
    }
}
