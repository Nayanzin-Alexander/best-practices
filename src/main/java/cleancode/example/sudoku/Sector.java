package cleancode.example.sudoku;

import java.util.Arrays;

public enum Sector {

    NORTH_WEST(0, 0),
    NORTH(0, 3),
    NORTH_EAST(0, 6),
    WEST(3, 0),
    CENTER(3, 3),
    EAST(3, 6),
    SOUTH_WEST(6, 0),
    SOUTH(6, 3),
    SOUTH_EAST(6, 6);

    private final int rowMin;
    private final int rowMax;
    private final int colMin;
    private final int colMax;

    Sector(int rowMin, int colMin) {
        this.rowMin = rowMin;
        this.rowMax = rowMin + 3;
        this.colMin = colMin;
        this.colMax = colMin + 3;
    }

    public void forEachCellInSector(IntBiConsumer consumer) {
        for (int row = rowMin; row < rowMax; row++) {
            for (int col = colMin; col < colMax; col++) {
                consumer.acceptAsInt(row, col);
            }
        }
    }

    public static Sector getSectorBy(int row, int col) {
        return Arrays.stream(Sector.values())
            .filter(sector -> sector.fits(row, col))
            .findFirst()
            .orElseThrow(RuntimeException::new);
    }

    private boolean fits(int row, int col) {
        return rowMin <= row && row < rowMax
            && colMin <= col && col < colMax;
    }
}
