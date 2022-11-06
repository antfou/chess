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
//Add sniper feature, use code from pawn class

public class Queen extends Piece{
    private final static int[] POSSIBLE_MOVES_NR = {-7,-6,-5,-1,1,5,6,7};

    public Queen(final int pieceNR, final Side pieceSide) {
        super(pieceNR, pieceSide);
    }
            //TODO: Make queens attack move long range
    @Override
    public Collection<Move> calculateLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();

        for (final int currentNr : POSSIBLE_MOVES_NR) {
            int possibleMoveNr = this.pieceNR;
            while(BoardUtils.isValidTileNr(possibleMoveNr)){
                if (isFirstColumnExclusions(this.pieceNR, currentNr) ||
                        isSixthColumnExclusions(this.pieceNR, currentNr)) {
                    break;
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
        return BoardUtils.FIRST_COLUMN[currentNr] && ((candidateExclusion == -1)) || ((candidateExclusion == -7)) || ((candidateExclusion == 5));
    }
    private static boolean isSixthColumnExclusions ( final int currentNr, final int candidateExclusion){
        return BoardUtils.SIXTH_COLUMN[currentNr] && ((candidateExclusion == 1)) || ((candidateExclusion == -5)) || ((candidateExclusion == 7));
    }
}