package Logic.Pieces;

import Logic.Players.Side;

public class Piece {

    protected final int pieceNR;
    protected final Side pieceSide;

    Piece(final int pieceNR, final Side pieceSide){
        this.pieceNR = pieceNR;
        this.pieceSide = pieceSide;
    }
}
