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

public class Tank extends Piece{

    private final static int[] POSSIBLE_MOVES_NR = {-1,-6,-6,1};
    Tank(final int pieceNR,final Side pieceSide) {
        super( pieceNR,  pieceSide);
    }

    @Override
    public Collection<Move> calculateLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();

        for (final int currentNr : POSSIBLE_MOVES_NR) {
             int possibleMoveNr = this.pieceNR;
             while(BoardUtils.isValidTileNr(possibleMoveNr)){
                 if (isFirstColumnExclusions(this.pieceNR, currentNr) ||
                         isSecondColumnExclusions(this.pieceNR, currentNr) ||
                         isThirdColumnExclusions(this.pieceNR, currentNr) ||
                         isFourthColumnExclusions(this.pieceNR, currentNr) ||
                         isFifthColumnExclusions(this.pieceNR, currentNr) ||
                         isSixthColumnExclusions(this.pieceNR, currentNr)) {
                     continue;
                 }
                 possibleMoveNr += currentNr;
                 if (BoardUtils.isValidTileNr(possibleMoveNr)){
                     if (isValidTileNr(possibleMoveNr)) {
                         final Tile possibleMoveTile = board.getTile(possibleMoveNr);
                         //Checks if tile is unoccupied to legalize the move, and adds move
                         if (!possibleMoveTile.isTileOccupied()) {
                             legalMoves.add(new Move.MajorMove(board, this, possibleMoveNr));
                         } else {
                             final Piece pieceOccupyingTile = possibleMoveTile.getPiece();
                             final Side pieceSide = pieceOccupyingTile.getPieceSide();
                             //Checks if piece is enemy to legalize the move, and adds move
                             if (this.pieceSide != pieceSide) {
                                 legalMoves.add(new Move.AttackMove(board, this, possibleMoveNr, pieceOccupyingTile));
                             }
                             break;
                         }
                     }
                 }
             }
        }
        return Collections.unmodifiableList(legalMoves);
    }
    private static boolean isFirstColumnExclusions ( final int currentNr, final int candidateExclusion){
        return BoardUtils.FIRST_COLUMN[currentNr] && ((candidateExclusion == -1)) || ((candidateExclusion == -2)) || ((candidateExclusion == -3));
    }
    private static boolean isSecondColumnExclusions ( final int currentNr, final int candidateExclusion){
        return BoardUtils.SECOND_COLUMN[currentNr] && ((candidateExclusion == -2)) || ((candidateExclusion == -3));
    }
    private static boolean isThirdColumnExclusions ( final int currentNr, final int candidateExclusion){
        return BoardUtils.THIRD_COLUMN[currentNr] && ((candidateExclusion == -3));
    }
    private static boolean isFourthColumnExclusions ( final int currentNr, final int candidateExclusion){
        return BoardUtils.FOURTH_COLUMN[currentNr] && ((candidateExclusion == 3));
    }
    private static boolean isFifthColumnExclusions ( final int currentNr, final int candidateExclusion){
        return BoardUtils.FIFTH_COLUMN[currentNr] && ((candidateExclusion == 2)) || ((candidateExclusion == 3));
    }
    private static boolean isSixthColumnExclusions ( final int currentNr, final int candidateExclusion){
        return BoardUtils.SIXTH_COLUMN[currentNr] && ((candidateExclusion == 1)) || ((candidateExclusion == 2)) || ((candidateExclusion == 3));
    }
}