package cleancode.example.sudoku;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku {

    private static final List<Integer> ALL_DIGITS = asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private String input;
    private StringBuilder result = new StringBuilder();
    private int array[][] = new int[9][9];
    private String solution = "";

    public void setInput(String input) {
        this.input = input;
    }

    public String getResult() {
        return result.toString();
    }

    public String getSolution() {
        return solution;
    }

    public void findSimpleSolution() {
        initCellsFromInput();
        int r = mainCycle();
        if (r == 0) {
            result.append("Succeeded");
        } else if (r == -2) {
            result.append("Too complex sudoku");
        }
    }

    /**
     * Return 0 - solved
     * ret -1 -- error
     * ret -2 -- cannot solve
     */
    private int mainCycle() {
        for (;;) {
            if (isSolved()) {
                show();
                return 0;
            }

            boolean isNotPerformedAction = true;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    int retCode = 0;
                    boolean isCellActionPerformed = false;
                    if (array[i][j] == 0) {
                        retCode = checkMe(i, j);
                        if (retCode > 0) { // cell was solved
                            isCellActionPerformed = true;
                        }
                    }
                    if (retCode == -1) {
                        result.append("ERROR: input is not a sudoku\n");
                        return -1;
                    }
                    if (isCellActionPerformed) {
                        isNotPerformedAction = false;
                    }
                }
            }

            if (isNotPerformedAction) { // no action for the whole table of cells
                return -2;
            }
        }
    }

    private int checkMe(int str, int col) {
        List<Integer> variants = new ArrayList<>(ALL_DIGITS);
        Set<Integer> variantsToExclude = new HashSet<>();
        variantsToExclude.addAll(getSolvedByRow(col));
        variantsToExclude.addAll(getSolvedByColumn(str));
        variantsToExclude.addAll(getSolvedBySector(str, col));
        variants.removeAll(variantsToExclude);
        if (variants.size() > 1) {
            return 0;
        } if (variants.isEmpty()) {
            return -1;
        }
        return array[str][col] = variants.get(0);
    }

    private List<Integer> getSolvedBySector(int str, int col) {
        int minI, maxI, minJ, maxJ;
        if (str <= 2) {
            minI = 0;
            maxI = 2;
        } else if (str <= 5) {
            minI = 3;
            maxI = 5;
        } else {
            minI = 6;
            maxI = 8;
        }

        if (col <= 2) {
            minJ = 0;
            maxJ = 2;
        } else if (col <= 5) {
            minJ = 3;
            maxJ = 5;
        } else {
            minJ = 6;
            maxJ = 8;
        }


        List<Integer> variants = new ArrayList<>();
        for (int i = minI; i <= maxI; i++) {
            for (int j = minJ; j <= maxJ; j++) {
                if (array[i][j] != 0) {
                    variants.add(array[i][j]);
                }
            }
        }
        return variants;
    }

    private List<Integer> getSolvedByRow(int col) {
        List<Integer> variants = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (array[i][col] != 0) {
                variants.add(array[i][col]);
            }
        }
        return variants;
    }

    private List<Integer> getSolvedByColumn(int str) {
        List<Integer> variants = new ArrayList<>();
        for (int j = 0; j < 9; j++) {
            if (array[str][j] != 0) {
                variants.add(array[str][j]);
            }
        }
        return variants;
    }

    private void show() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(array[i][j]);
            }
            sb.append("\n");
        }
        solution = sb.toString();
    }

    private boolean isSolved() {
        boolean isSolved = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (array[i][j] == 0) {
                    isSolved = false;
                }
            }
        }
        return isSolved;
    }

    private void initCellsFromInput() {
        String rows[] = input.split("\n");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = rows[i].charAt(j);
                if (c == ' ') {
                    array[i][j] = 0;
                } else if (Character.getNumericValue(c) <= 9 && Character.getNumericValue(c) > 0) {
                    array[i][j] = Character.getNumericValue(c);
                } else {
                    throw new RuntimeException("Wrong input format");
                }
            }
        }
    }
}
