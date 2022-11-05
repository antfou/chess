package Logic.Board;

import Logic.Pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int tileNR;

    private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllEmptyTiles();

    private static Map<Integer, EmptyTile> createAllEmptyTiles() {

        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
        for (int i = 0; i < 36; i++) {
            emptyTileMap.put(i,new EmptyTile(i));
        }
        return emptyTileMap;
    }

    public static Tile createTile(final int tileNR, final Piece piece){
        return piece != null ? new OccupiedTile(tileNR, piece) : EMPTY_TILES.get(tileNR);
    }

    private Tile(int tileNR){
        this.tileNR = tileNR;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile {
        EmptyTile(final int nr) {
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

        private final Piece pieceOnTile;

        OccupiedTile(final int nr, Piece pieceOnTile){
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
