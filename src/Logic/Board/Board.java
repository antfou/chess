package Logic.Board;

import Logic.Pieces.Piece;
import Logic.Players.Side;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Board {

    private final List<Tile> gameBoard;

    private Board(Builder builder){
        this.gameBoard = createGameBoard(builder);
    }

    public Tile getTile(final int intCoordinate){
        return null;
    }

    private static List<Tile> createGameBoard(final Builder builder){
        final Tile[] tiles = new Tile[BoardUtils.NUM_TILES];
        for (int i = 0; i < BoardUtils.NUM_TILES; i++){
            tiles[i] = Tile.createTile(i,builder.boardConfig.get(i));
        }
        return List.of(tiles);
    }
    public static Board createStandardBoard(){
        return null;
    }

    public static class Builder{

        Map<Integer, Piece> boardConfig;
        Side turnPlayer;

        public Builder(){
        }
        public Builder setPiece(final Piece piece){
            this.boardConfig.put(piece.getPieceNR(), piece);
            return this;
        }

        public Builder setMoveMaker(final Side turnPlayer){
            this.turnPlayer = turnPlayer;
            return this;
        }

        public Board build(){
            return new Board(this);
        }
    }
}
