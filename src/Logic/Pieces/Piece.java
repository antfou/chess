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
    protected final boolean isFirstMove;

    Piece(final int pieceNR, final Side pieceSide){
        this.pieceNR = pieceNR;
        this.pieceSide = pieceSide;
        //TODO: get back to this one
        this.isFirstMove = false;
    }
    public int getPieceNR(){
        return this.pieceNR;
    }

    //Method for determining color of piece
    public Side getPieceSide(){
        return this.pieceSide;
    }

    public boolean isFirstMove(){
        return this.isFirstMove;
    }
    //Abstract method for movement
    public abstract Collection<Move> calculateLegalMoves(final Board board);
}
