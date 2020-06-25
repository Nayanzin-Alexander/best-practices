package cleancode;

public class DRYRules {

    public static final String DONT_REPEAT_YOURSELF =
        "DRY principles\n"
            + " * Every peace of knowledge should have single, unambiguous and authoritative "
            + "representation within the system\n"
            + " * When the DRY principle is applied successfully, a modification of any piece of code"
            + "doesn't require a change in other logically unrelated elements.\n"
            + " * Elements that are logically related all change predictably and uniformly, and are"
            + "thus kepr in sync.\n\n";

    public static final String WRITE_EVERY_TIME =
        "WET principles:\n"
            + " * Knowledge is expressed in two or more places.\n"
            + " * You need to find all occurrences and fix everywhere.\n"
            + " * It isn't a question of whether you'll remember, "
            + "it's the question of when you will forget.\n\n";

    public static void main(String[] args) {
        System.out.println(DONT_REPEAT_YOURSELF);
        System.out.println(WRITE_EVERY_TIME);
    }
}
