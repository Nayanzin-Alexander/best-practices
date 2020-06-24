package cleancode.function;

import static java.util.Objects.isNull;

import java.sql.SQLOutput;
import java.util.Optional;
import utils.annotation.Compliant;
import utils.annotation.NonCompliant;

public class ParameterRules {

    @NonCompliant("Boolean is used as a flag parameter")
    public int compare(int x, int y, boolean compareByModule) {
        if (compareByModule) {
            return Integer.compare(Math.abs(x), Math.abs(y));
        } else {
            return Integer.compare(x, y);
        }
    }

    @Compliant("Instead of using boolean parameter function is splitted")
    public int compareByModule(int x, int y) {
        return Integer.compare(Math.abs(x), Math.abs(y));
    }

    @Compliant("Instead of using boolean parameter function is splitted")
    public int compare(int x, int y) {
        return Integer.compare(x, y);
    }

    @NonCompliant("Do not accept NULL and do not return NULL")
    public void doNotAcceptAndReturnNullNotCompliant() {
        String text = readFromDBReturnNullIfNotFound();
        printTextNotCompliant(text);
    }

    @NonCompliant("Do not accept NULL")
    private void printTextNotCompliant(String text) {
        if (isNull(text)) {
            printTextNotFound();
        } else {
            System.out.println(text);
        }
    }

    @NonCompliant("Do not return NULL")
    private String readFromDBReturnNullIfNotFound() {
        String text = null;
        return null;
    }

    @Compliant("Do not accept NULL and do not return NULL")
    public void doNotAcceptAndReturnNull() {
        Optional<String> text = readTextFromDB();
        if (text.isPresent()) {
            printText(text.get());
        } else {
            printTextNotFound();
        }
    }

    private void printTextNotFound() {
        System.out.println("Text not found");
    }

    @Compliant("Do not accept NULL, assume argument is not null")
    private void printText(String text) {
        System.out.println(text);
    }

    @Compliant("Do not return NULL, return Optional or throw Exception instead")
    private Optional<String> readTextFromDB() {
        return Optional.of(null);
    }
}
