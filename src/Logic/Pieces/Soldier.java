package Logic.Pieces;

import Logic.Board.Board;
import Logic.Board.Move;
import Logic.Board.Tile;
import Logic.Players.Side;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Soldier extends Piece{
    //The MAXIMUM amount of legal moves for this piece
    private final static int[] POSSIBLE_MOVES_NR = {-1,-5,-6,-7,7,6,5,1};
    Soldier(final int pieceNR, final Side pieceSide) {
        super(pieceNR, pieceSide);
    }
    //Calculate all the legal moves
    @Override
    public List<Move> calculateLegalMoves(Board board) {

        int possibleMoveNr;
        final List<Move> legalMoves = new ArrayList<>();

        for(final int currentNr : POSSIBLE_MOVES_NR){

            possibleMoveNr = this.pieceNR + currentNr;

            if(true ){
                final Tile possibleMoveTile = board.getTile(possibleMoveNr);
                //Checks if tile is unoccupied to legalize the move, and adds move
                if(!possibleMoveTile.isTileOccupied()){
                    legalMoves.add(new Move());
                }else{
                    final Piece pieceOccupyingTile = possibleMoveTile.getPiece();
                    final Side pieceSide = pieceOccupyingTile.getPieceSide();
                    //Checks if piece is enemy to legalize the move, and adds move
                    if(this.pieceSide != pieceSide){
                        legalMoves.add(new Move());
                    }
                }
            }

        }
        return Collections.unmodifiableList(legalMoves);
    }
}
