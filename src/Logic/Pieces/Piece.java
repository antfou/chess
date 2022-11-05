package Logic.Pieces;

import Logic.Board.Board;
import Logic.Board.Move;
import Logic.Players.Side;

import java.util.List;

public abstract class Piece {
    //Coordinates
    protected final int pieceNR;
    //Allegiance(is black or is white)
    protected final Side pieceSide;

    Piece(final int pieceNR, final Side pieceSide){
        this.pieceNR = pieceNR;
        this.pieceSide = pieceSide;
    }
    //Abstract method for movement
    public abstract List<Move> calculateLegalMoves(final Board board);
}
