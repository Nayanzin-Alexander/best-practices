package cleancode.example.sudoku;

import static java.util.Arrays.asList;

import cleancode.example.sudoku.exception.ComplexSudokuException;
import cleancode.example.sudoku.exception.NoCellVariantsException;
import cleancode.example.sudoku.exception.SudokuException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku {

    public static final int MAX_DIGIT = 9;
    private static final List<Integer> ALL_DIGITS = asList(1, 2, 3, 4, 5, 6, 7, 8, MAX_DIGIT);
    private String input;
    private final StringBuilder result = new StringBuilder();
    private final int[][] table = new int[MAX_DIGIT][MAX_DIGIT];
    private String solution = "";
    private boolean noTableAction = false;

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
        initTableCellsFromInput();
        findSolutionOfTable();
    }

    private void findSolutionOfTable() {
        try {
            tryFindSimpleSolution();
            addSolution();
            result.append("Succeeded");
        } catch (NoCellVariantsException e) {
            result.append("ERROR: input is not a sudoku\n");
        } catch (ComplexSudokuException e) {
            result.append("Too complex sudoku");
        }
    }

    /**
     * Return 0 - solved ret -1 -- error ret -2 -- cannot solve
     */
    private void tryFindSimpleSolution() {
        while (!isSolved()) {
            trySolveSudoku();
            assertActionPerformed();
        }
    }

    private void assertActionPerformed() {
        if (noTableAction) {
            throw new ComplexSudokuException();
        }
    }

    private void trySolveSudoku() {
        noTableAction = true;
        forEachCell((i, j) -> {
            if (!isSolvedCell(i, j)) {
                trySolveCell(i, j);
            }
        });
    }

    private void forEachCell(IntBiConsumer action) {
        for (int i = 0; i < MAX_DIGIT; i++) {
            for (int j = 0; j < MAX_DIGIT; j++) {
                action.acceptAsInt(i, j);
            }
        }
    }

    private void trySolveCell(int i, int j) {
        int cellSolution = tryFindSolvedCell(i, j);
        if (cellSolution > 0) {
            table[i][j] = cellSolution;
            noTableAction = false;
        }
    }

    private boolean isSolvedCell(int i, int j) {
        return table[i][j] != 0;
    }

    private int tryFindSolvedCell(int str, int col) {
        List<Integer> cellVariants = getCellVariants(str, col);
        if (cellVariants.size() > 1) {
            return 0;
        }
        if (cellVariants.isEmpty()) {
            throw new NoCellVariantsException();
        }
        return cellVariants.get(0);
    }

    private List<Integer> getCellVariants(int str, int col) {
        List<Integer> variants = new ArrayList<>(ALL_DIGITS);
        Set<Integer> variantsToExclude = new HashSet<>();
        variantsToExclude.addAll(getSolvedByRow(col));
        variantsToExclude.addAll(getSolvedByColumn(str));
        variantsToExclude.addAll(getSolvedBySector(str, col));
        variants.removeAll(variantsToExclude);
        return variants;
    }

    private List<Integer> getSolvedBySector(int str, int col) {
        Sector sector = Sector.getSectorBy(str, col);
        List<Integer> variants = new ArrayList<>();
        sector.forEachCellInSector((r, c) -> {
            if (isSolvedCell(r, c)) {
                variants.add(table[r][c]);
            }
        });
        return variants;
    }

    private List<Integer> getSolvedByRow(int col) {
        List<Integer> variants = new ArrayList<>();
        for (int i = 0; i < MAX_DIGIT; i++) {
            if (isSolvedCell(i, col)) {
                variants.add(table[i][col]);
            }
        }
        return variants;
    }

    private List<Integer> getSolvedByColumn(int str) {
        List<Integer> variants = new ArrayList<>();
        for (int j = 0; j < MAX_DIGIT; j++) {
            if (isSolvedCell(str, j)) {
                variants.add(table[str][j]);
            }
        }
        return variants;
    }

    private void addSolution() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_DIGIT; i++) {
            for (int j = 0; j < MAX_DIGIT; j++) {
                sb.append(table[i][j]);
            }
            sb.append("\n");
        }
        solution = sb.toString();
    }

    private boolean isSolved() {
        for (int i = 0; i < MAX_DIGIT; i++) {
            for (int j = 0; j < MAX_DIGIT; j++) {
                if (!isSolvedCell(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void initTableCellsFromInput() {
        String[] rows = input.split("\n");
        forEachCell((row, col) -> {
            char c = rows[row].charAt(col);
            if (c == ' ') {
                table[row][col] = 0;
            } else if (Character.getNumericValue(c) <= MAX_DIGIT
                && Character.getNumericValue(c) > 0) {
                table[row][col] = Character.getNumericValue(c);
            } else {
                throw new SudokuException("Wrong input format");
            }
        });
    }
}