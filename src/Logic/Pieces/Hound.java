package Logic.Pieces;

import Logic.Board.Board;
import Logic.Board.BoardUtils;
import Logic.Board.Move;
import Logic.Players.Side;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hound extends Piece{
    private final static int[] POSSIBLE_MOVES_NR = {6, 5, 7};

    Hound(final int pieceNR, final Side pieceSide) {
        super(pieceNR, pieceSide);
    }

    @Override
    public Collection<Move> calculateLegalMoves(Board board) {

        final List<Move> legalMoves = new ArrayList<>();
        for (final int currentNr : POSSIBLE_MOVES_NR) {
            final int possibleMoveNr = this.pieceNR + (this.getPieceSide().getDirection() * currentNr);
            if(!BoardUtils.isValidTileNr(possibleMoveNr)){
                continue;
            }
            if(currentNr == 8 && !board.getTile(possibleMoveNr).isTileOccupied()){
                legalMoves.add(new Move.MajorMove(board,this,possibleMoveNr));
            }else if(currentNr == 5 && this.isFirstMove() &&
                    (BoardUtils.SECOND_ROW[this.pieceNR] && this.getPieceSide().isBlack()) ||
                    (BoardUtils.FIFTH_ROW[this.pieceNR] && this.getPieceSide().isWhite())){
                        legalMoves.add(new Move.MajorMove(board,this,currentNr));

            }else if(currentNr == 7 && this.isFirstMove() &&
                    (BoardUtils.SECOND_ROW[this.pieceNR] && this.getPieceSide().isBlack()) ||
                    (BoardUtils.FIFTH_ROW[this.pieceNR] && this.getPieceSide().isWhite())){
                        legalMoves.add(new Move.MajorMove(board,this,currentNr));


            }

        }
        return null;
    }
}
