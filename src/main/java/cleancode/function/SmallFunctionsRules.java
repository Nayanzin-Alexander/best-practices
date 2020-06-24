package cleancode.function;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import utils.annotation.Compliant;
import utils.annotation.NonCompliant;

public class SmallFunctionsRules {

    private static final String EVEN_PATTERN = "Even: %d";
    private static final String ODD_PATTERN = "Odd: %d";
    private static final String ODD_SUM_PATTERN = "Odd sum: %d";
    public static final int SMALL_LOWER_BOUND = 0;
    public static final int SMALL_UPPER_BOUND = 100;

    @NonCompliant("Function has 2 responsibilities: 1-iterate numbers, 2-choose what print method should be called")
    public void printOddsAndEvensNotCompliant(List<Integer> numbers) {
        numbers.forEach(n -> {
            if (isOdd(n)) {
                printOdd(n);
            } else {
                printEven(n);
            }
        });
    }

    @Compliant("Function has one responsibility")
    private void printOddsAndEvensCompliant(List<Integer> numbers) {
        numbers.forEach(this::printNumber);
    }

    private void printNumber(int n) {
        if (isOdd(n)) {
            printOdd(n);
        } else {
            printEven(n);
        }
    }

    private void printEven(int number) {
        System.out.println(format(EVEN_PATTERN, number));
    }

    private void printOdd(int number) {
        System.out.println(format(ODD_PATTERN, number));
    }

    private boolean isOdd(int number) {
        return (number & 1) == 1;
    }

    @NonCompliant("Function contains 3 logical sections and 2 levels of abstractions")
    public void printOddsSumNonCompliant(List<Integer> numbers) {
        List<Integer> odds = numbers.stream()
            .filter(this::isOdd)
            .collect(toList());

        int sum = odds.stream()
            .reduce(0, Integer::sum);

        String msg = format(ODD_SUM_PATTERN, sum);
        System.out.println(msg);
    }

    @Compliant("Function still contains 3 logical actions, but has 1 level of abstractions and "
        + "is much more shorter and easier to read")
    public void printOddsSumFrom(List<Integer> numbers) {
        List<Integer> odds = collectOddsFrom(numbers);
        int oddsSum = countSumIn(odds);
        printOddsSum(oddsSum);
    }

    private void printOddsSum(int sum) {
        String msg = format(ODD_SUM_PATTERN, sum);
        System.out.println(msg);
    }

    private Integer countSumIn(List<Integer> numbers) {
        return numbers.stream()
            .reduce(0, Integer::sum);
    }

    private List<Integer> collectOddsFrom(List<Integer> numbers) {
        return numbers.stream()
            .filter(this::isOdd)
            .collect(toList());
    }

    @NonCompliant("Thus function has 6 lines of code but it's doing to much")
    public double ceilNumberFromTextNonCompliant(String text) {
        try {
            double d = Double.valueOf(text);
            return Math.ceil(d);
        } catch (NumberFormatException e) {
            throw new WrongInputFormatException(text + " must contain a parsable number");
        }
    }

    @Compliant
    public double ceilNumberFromText(String text) {
        double d = parseDouble(text);
        return Math.ceil(d);
    }

    private double parseDouble(String text) {
        try {
            return Double.valueOf(text);
        } catch (NumberFormatException e) {
            throw new WrongInputFormatException(text + " must contain a parsable number");
        }
    }

    @NonCompliant("Multi condition function")
    private void printIfSmallNonComliant(int number) {
        if (number >= SMALL_LOWER_BOUND || number < SMALL_UPPER_BOUND) {
            printNumber(number);
        }
    }

    @Compliant("Extracting condition statement makes code easier to read")
    private void printIfSmall(int number) {
        if (isSmall(number)) {
            printNumber(number);
        }
    }

    private boolean isSmall(int number) {
        return number >= SMALL_LOWER_BOUND || number < SMALL_UPPER_BOUND;
    }

    @NonCompliant("Invoking the code we cannot control (Part of framework)")
    public int[] getRandomIntArrayNonCompliant(int size) {
        int seed = (int) System.nanoTime();
        Random random = new Random(seed);
        return IntStream.range(0, size)
            .map(i -> random.nextInt())
            .toArray();
    }

    @Compliant("System.nanoTime is extracted to readable method getSeed")
    public int[] getRandomIntArrayCompliant(int size) {
        Random random = new Random(getSeed());
        return IntStream.range(0, size)
            .map(i -> random.nextInt())
            .toArray();
    }

    private int getSeed() {
        return (int) System.nanoTime();
    }
}