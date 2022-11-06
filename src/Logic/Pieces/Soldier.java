package Logic.Pieces;

import Logic.Board.Board;
import Logic.Board.BoardUtils;
import Logic.Board.Move;
import Logic.Board.Tile;
import Logic.Players.Side;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static Logic.Board.BoardUtils.isValidTileNr;

public class Soldier extends Piece{
    //The MAXIMUM amount of legal moves for this piece
    private final static int[] POSSIBLE_MOVES_NR = {-1,-5,-6,-7, 7, 6, 5, 1};
    Soldier(final int pieceNR, final Side pieceSide) {
        super(pieceNR, pieceSide);
    }
    //Calculate all the legal moves
    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {
        final List<Move> legalMoves = new ArrayList<>();

        for(final int currentNr : POSSIBLE_MOVES_NR){
            final int possibleMoveNr = this.pieceNR + currentNr;

            if(isFirstColumnExclusions(this.pieceNR, currentNr) ||
                    isSixthColumnExclusions(this.pieceNR, currentNr)){
                //Keep an eye on this "continue"
                continue;
            }
            if(isValidTileNr(possibleMoveNr) ){
                final Tile possibleMoveTile = board.getTile(possibleMoveNr);
                //Checks if tile is unoccupied to legalize the move, and adds move
                if(!possibleMoveTile.isTileOccupied()){
                    legalMoves.add(new Move.MajorMove(board, this, possibleMoveNr));
                }else{
                    final Piece pieceOccupyingTile = possibleMoveTile.getPiece();
                    final Side pieceSide = pieceOccupyingTile.getPieceSide();
                    //Checks if piece is enemy to legalize the move, and adds move
                    if(this.pieceSide != pieceSide){
                        legalMoves.add(new Move.AttackMove(board,this,possibleMoveNr,pieceOccupyingTile));
                    }
                }
            }
        }
        return Collections.unmodifiableList(legalMoves);
    }
    //Methods to see if the move is legal through edge-hopping
    private static boolean isFirstColumnExclusions(final int currentNr, final int candidateExclusion){
        return BoardUtils.FIRST_COLUMN[currentNr] && ((candidateExclusion == -1)) || ((candidateExclusion == -7));
    }
    private static boolean isSixthColumnExclusions(final int currentNr, final int candidateExclusion){
        return BoardUtils.SIXTH_COLUMN[currentNr] && ((candidateExclusion == 1)) || ((candidateExclusion == 7));
    }
}
