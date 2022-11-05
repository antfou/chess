package Logic.Board;

import Logic.Pieces.Piece;

public abstract class Tile {

    int tileNR;
    boolean color;

    Tile(int tileNR){
        this.tileNR = tileNR;
        this.color = color;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile {
        EmptyTile(int nr) {
            super(nr);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }

    }

    public static final class OccupiedTile extends Tile{

        Piece pieceOnTile;

        OccupiedTile(int nr, Piece pieceOnTile){
            super(nr);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }
    }


}
