package cleancode;

public class PrinciplesOfCleanCodePrinter {

    public static void main(String[] args) {
        String cleanCodePrinciples = "\n\nWhat is clean code?\n"
            + "Clean code is focused.\n"
            + "In a piece of cleanly written code, each class, method and function are "
            + "separate and undisturbed by one another\n\n"
            + "Code is non redundant\n"
            + "Code complies with DRY rule\n\n"
            + "Code is pleasant\n"
            + "Looking through a clean code is like a reading a well authored reference book\n\n"
            + "Clean code is easily extended\n"
            + "Clean code is written  with other developers in mind\n\n"
            + "Clean code has minimal dependencies\n"
            + "The minimal dependencies in clean code makes it easier to maintain."
            + "Classes and methods are short and the code itself is well divided\n\n"
            + "Clean code has tests\n"
            + "Clean code is tested to ensure it complies with requirements\n\n"
            + "Clean code is expressive\n"
            + "Clean code has meaning full names that are distinct and express "
            + "their intention\n\n";
        System.out.println(cleanCodePrinciples);
    }
}
