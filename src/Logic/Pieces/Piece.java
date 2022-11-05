package Logic.Pieces;

import Logic.Board.Board;
import Logic.Board.Move;
import Logic.Players.Side;

import java.util.Collection;

public abstract class Piece {
    //Coordinates
    protected final int pieceNR;
    //Allegiance(is black or is white)
    protected final Side pieceSide;

    Piece(final int pieceNR, final Side pieceSide){
        this.pieceNR = pieceNR;
        this.pieceSide = pieceSide;
    }

    //Method for determining color of piece
    public Side getPieceSide(){
        return this.pieceSide;
    }
    //Abstract method for movement
    public abstract Collection<Move> calculateLegalMoves(final Board board);
}
