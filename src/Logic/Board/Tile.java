package Logic.Board;

import Logic.Pieces.Piece;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile {
    //Coordinates
    protected final int tileNR;
    //Map of empty tiles
    private static final Map<Integer, EmptyTile> EMPTY_TILES = createAllEmptyTiles();
    //Creates the map of empty tiles
    private static Map<Integer, EmptyTile> createAllEmptyTiles() {

        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
        for (int i = 0; i < BoardUtils.NUM_TILES; i++) {
            emptyTileMap.put(i,new EmptyTile(i));
        }
        return Collections.unmodifiableMap(emptyTileMap);
    }
    //Creates a tile, uses piece to check if the tile is empty
    public static Tile createTile(final int tileNR, final Piece piece){
        return piece != null ? new OccupiedTile(tileNR, piece) : EMPTY_TILES.get(tileNR);
    }

    private Tile(final int tileNR){
        this.tileNR = tileNR;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();
    //Subclass for all the empty tiles
    public static final class EmptyTile extends Tile {
        private EmptyTile(final int nr) {
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
    //Subclass for all the occupied tiles
    public static final class OccupiedTile extends Tile{

        private final Piece pieceOnTile;

        private OccupiedTile(final int nr, final Piece pieceOnTile){
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
