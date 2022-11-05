package Logic.Board;

public class BoardUtils {

    public static final Boolean[] FIRST_COLUMN = null;
    public static final Boolean[] SECOND_COLUMN = null;
    public static final Boolean[] THIRD_COLUMN = null;
    public static final Boolean[] FOURTH_COLUMN = null;
    public static final Boolean[] FIFTH_COLUMN = null;
    public static final Boolean[] SIXTH_COLUMN = null;

    private BoardUtils(){
        throw new RuntimeException("You are not supposed to be using me!");
    }
    //Checks if move is within bounds
    public static boolean isValidTileNr(int nr) {
        return nr >=0 && nr < 35;
    }
}
