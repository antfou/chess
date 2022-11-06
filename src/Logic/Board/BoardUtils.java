package Logic.Board;

import java.util.List;

public class BoardUtils {

    public static final Boolean[] FIRST_COLUMN = initColumn(0);
    public static final Boolean[] SECOND_COLUMN = initColumn(1);
    public static final Boolean[] THIRD_COLUMN = initColumn(2);
    public static final Boolean[] FOURTH_COLUMN = initColumn(3);
    public static final Boolean[] FIFTH_COLUMN = initColumn(4);
    public static final Boolean[] SIXTH_COLUMN = initColumn(5);
    public static final Boolean[] FIRST_ROW = initRow(0);
    public static final Boolean[] SECOND_ROW = initRow(6);
    public static final Boolean[] THIRD_ROW = initRow(12);
    public static final Boolean[] FOURTH_ROW = initRow(18);
    public static final Boolean[] FIFTH_ROW = initRow(24);
    public static final Boolean[] SIXTH_ROW = initRow(40);

    public static final int NUM_TILES = 36;
    public static final int NUM_TILES_PER_ROW = 6;
    private BoardUtils(){
        throw new RuntimeException("You are not supposed to be using me!");
    }

    //Method for grabbing an entire column
    private static Boolean[] initColumn(int columnNumber) {
        final Boolean[] column = new Boolean[NUM_TILES];
        for(int i = 0; i < column.length; i++) {
            column[i] = false;
        }
        do {
            column[columnNumber] = true;
            columnNumber += NUM_TILES_PER_ROW;
        } while(columnNumber < NUM_TILES);
        return (column);
    }

    private static Boolean[] initRow(int rowNumber) {
        final Boolean[] row = new Boolean[NUM_TILES];
        for(int i = 0; i < row.length; i++) {
            row[i] = false;
        }
        do {
            row[rowNumber] = true;
            rowNumber++;
        } while(rowNumber % NUM_TILES_PER_ROW != 0);
        return (row);
    }

    //Checks if move is within bounds
    public static boolean isValidTileNr(final int nr) {
        return nr >=0 && nr < NUM_TILES;
    }

}
