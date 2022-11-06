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

public class Hound extends Piece{
    private final static int[] POSSIBLE_MOVES_NR = {6, 5, 7};

    public Hound(final int pieceNR, final Side pieceSide) {
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
            if(currentNr == 6 && !board.getTile(possibleMoveNr).isTileOccupied()){
                final Tile possibleMoveTile = board.getTile(possibleMoveNr);
                if(!possibleMoveTile.isTileOccupied()){
                    //Adds moving move
                    legalMoves.add(new Move.MajorMove(board, this, possibleMoveNr));
                }else{
                    final Piece pieceOccupyingTile = possibleMoveTile.getPiece();
                    final Side pieceSide = pieceOccupyingTile.getPieceSide();
                    //Adds attacking move
                    if(this.pieceSide != pieceSide){
                        legalMoves.add(new Move.AttackMove(board,this,possibleMoveNr,pieceOccupyingTile));
                    }
                }
                //Hound start-move, move right.
            }else if(currentNr == 5 && this.isFirstMove() &&
                    (BoardUtils.SECOND_ROW[this.pieceNR] && this.getPieceSide().isBlack()) ||
                    (BoardUtils.FIFTH_ROW[this.pieceNR] && this.getPieceSide().isWhite())){
                final Tile possibleMoveTile = board.getTile(possibleMoveNr);
                if(!possibleMoveTile.isTileOccupied()){
                    //Adds moving move
                    legalMoves.add(new Move.MajorMove(board, this, possibleMoveNr));
                }else{
                    final Piece pieceOccupyingTile = possibleMoveTile.getPiece();
                    final Side pieceSide = pieceOccupyingTile.getPieceSide();
                    //Adds attacking move
                    if(this.pieceSide != pieceSide){
                        legalMoves.add(new Move.AttackMove(board,this,possibleMoveNr,pieceOccupyingTile));
                    }
                }
                //Hound start-move, move left.
            }else if(currentNr == 7 && this.isFirstMove() &&
                    (BoardUtils.SECOND_ROW[this.pieceNR] && this.getPieceSide().isBlack()) ||
                    (BoardUtils.FIFTH_ROW[this.pieceNR] && this.getPieceSide().isWhite())){
                final Tile possibleMoveTile = board.getTile(possibleMoveNr);
                if(!possibleMoveTile.isTileOccupied()){
                    //Adds moving move
                    legalMoves.add(new Move.MajorMove(board, this, possibleMoveNr));
                }else{
                    final Piece pieceOccupyingTile = possibleMoveTile.getPiece();
                    final Side pieceSide = pieceOccupyingTile.getPieceSide();
                    //Adds attacking move
                    if(this.pieceSide != pieceSide){
                        legalMoves.add(new Move.AttackMove(board,this,possibleMoveNr,pieceOccupyingTile));
                    }
                }
            }
        }
        return Collections.unmodifiableList(legalMoves);
    }
}
