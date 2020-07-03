package cleancode.example.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuTest {

    private Sudoku sudoku = new Sudoku();

    @Test
    public void shouldSolveSimpleSudoku() {
        sudoku.setInput(
            "2  5  8 3\n" +
            "  6      \n" +
            "51   2 49\n" +
            "46    9 5\n" +
            "   1 3   \n" +
            " 21     7\n" +
            " 3 4   62\n" +
            "   3  5  \n" +
            "6 7  8  4"
        );
        sudoku.findSimpleSolution();
        assertEquals("Succeeded" , sudoku.getResult());
        assertEquals("294561873\n" +
            "376849251\n" +
            "518732649\n" +
            "463287915\n" +
            "785193426\n" +
            "921654387\n" +
            "839415762\n" +
            "142376598\n" +
            "657928134\n", sudoku.getSolution());
    }

    @Test
    public void shouldNotSolveComplexSudoku() {
        sudoku.setInput("  53     \n" +
            "8      2 \n" +
            " 7  1 5  \n" +
            "4    53  \n" +
            " 1  7   6\n" +
            "  32   8 \n" +
            " 6 5    9\n" +
            "  4    3 \n" +
            "     97  ");

        sudoku.findSimpleSolution();
        assertEquals("Too complex sudoku" , sudoku.getResult());
        assertEquals("", sudoku.getSolution());
    }

    @Test
    public void shouldNotSolveMoreComplexSudoku() {
        sudoku.setInput("   5  8 3\n" +
            "3768492 1\n" +
            "       4 \n" +
            " 6      5\n" +
            "   1 3   \n" +
            " 2       \n" +
            "   4     \n" +
            "      5  \n" +
            "6    8  4");

        sudoku.findSimpleSolution();
        assertEquals("Too complex sudoku" , sudoku.getResult());
    }

    @Test
    public void shouldPrintErrorWhenSudokuIsWrong() {
        sudoku.setInput("1  5  8 3\n" +
            "  6 49   \n" +
            "51   2 49\n" +
            "46    915\n" +
            "   1 3   \n" +
            "921    87\n" +
            "83 4   62\n" +
            "   37 5  \n" +
            "6 7  8  4");

        sudoku.findSimpleSolution();
        assertEquals("ERROR: input is not a sudoku\n" , sudoku.getResult());
        assertEquals("", sudoku.getSolution());

    }

    @Test(expected = RuntimeException.class)
    public void shouldTrowExceptionWhenInputContainsNotDigitsOrSpaces() {
        sudoku.setInput("1  5  8 3\n" + "tk6 49   \n");
        sudoku.findSimpleSolution();
    }

    @Test(expected = RuntimeException.class)
    public void shouldTrowExceptionWhenNotEnoughInput() {
        sudoku.setInput("1  5  8 3\n" + "  6 49   \n");
        sudoku.findSimpleSolution();
    }
}