package Logic.Board;

public class BoardUtils {

    public static final boolean[] FIRST_COLUMN = initColumn(0);
    public static final boolean[] SECOND_COLUMN = initColumn(1);
    public static final boolean[] THIRD_COLUMN = initColumn(2);
    public static final boolean[] FOURTH_COLUMN = initColumn(3);
    public static final boolean[] FIFTH_COLUMN = initColumn(4);
    public static final boolean[] SIXTH_COLUMN = initColumn(5);
    public static final boolean[] SECOND_ROW = null;
    public static final boolean[] FIFTH_ROW = null;

    public static final int NUM_TILES = 36;
    public static final int NUM_TILES_PER_ROW = 6;
    private BoardUtils(){
        throw new RuntimeException("You are not supposed to be using me!");
    }

    //Method for grabbing an entire column
    private static boolean[] initColumn(int columnNumber) {
        final boolean[] column = new boolean[NUM_TILES];
        do{
            column[columnNumber] = true;
            columnNumber += NUM_TILES_PER_ROW;
        }while (columnNumber < NUM_TILES);
        return column;
    }

    //Checks if move is within bounds
    public static boolean isValidTileNr(final int nr) {
        return nr >=0 && nr < NUM_TILES;
    }

}
