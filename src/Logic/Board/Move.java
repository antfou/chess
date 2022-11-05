package Logic.Board;

import Logic.Pieces.Piece;

public abstract class Move {

    final Board board;
    final Piece movedPiece;
    final int destinationNr;

    private Move(final Board board,
         final Piece movedPiece,
           final int destinationNr){
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationNr = destinationNr;
    }

    public static final class MajorMove extends Move{

        public MajorMove(final Board board, final Piece movedPiece, final int destinationNr) {
            super(board, movedPiece, destinationNr);
        }
    }
    public static final class AttackMove extends Move{

        final Piece attackedPiece;

        public AttackMove(final Board board, final Piece movedPiece, final int destinationNr, final Piece attackedPiece) {
            super(board, movedPiece, destinationNr);
            this.attackedPiece = attackedPiece;

        }

    }

}
