package Logic.Board;

import Logic.Pieces.*;
import Logic.Players.Side;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Board {

    private final List<Tile> gameBoard;
    private final Collections whitePieces;
    private final Collections blackPieces;

    private Board(Builder builder){
        this.gameBoard = createGameBoard(builder);
        this.whitePieces = calculateActivePieces(this.gameBoard, Side.WHITE);
        this.blackPieces = calculateActivePieces(this.gameBoard, Side.BLACK);
    }

    private Collections calculateActivePieces(final List<Tile> gameBoard,final  Side side) {
        final List<Piece> activePieces = new ArrayList<>();

        for(final Tile tile : gameBoard) {
            if(tile.isTileOccupied()){
                final Piece piece = tile.getPiece();
                if(piece.getPieceSide() == side){
                    activePieces.add(piece);
                    }
                }
            }

        return (Collections) activePieces;
        }


    public Tile getTile(final int intCoordinate){
        return gameBoard.get(intCoordinate);
    }

    private static List<Tile> createGameBoard(final Builder builder){
        final Tile[] tiles = new Tile[BoardUtils.NUM_TILES];
        for (int i = 0; i < BoardUtils.NUM_TILES; i++){
            tiles[i] = Tile.createTile(i,builder.boardConfig.get(i));
        }
        return List.of(tiles);
    }
    public static Board createStandardBoard(){
        final Builder builder = new Builder();
        //Black pieces
        builder.setPiece(new Tank(0,Side.BLACK));
        builder.setPiece(new Soldier(1,Side.BLACK));
        builder.setPiece(new King(2,Side.BLACK));
        builder.setPiece(new Queen(3,Side.BLACK));
        builder.setPiece(new Soldier(4,Side.BLACK));
        builder.setPiece(new Tank(5,Side.BLACK));
        builder.setPiece(new Hound(7,Side.BLACK));
        builder.setPiece(new Soldier(8,Side.BLACK));
        builder.setPiece(new Soldier(9,Side.BLACK));
        builder.setPiece(new Hound(10,Side.BLACK));
        //White pieces
        builder.setPiece(new Tank(53,Side.WHITE));
        builder.setPiece(new Soldier(52,Side.WHITE));
        builder.setPiece(new King(51,Side.WHITE));
        builder.setPiece(new Queen(50,Side.WHITE));
        builder.setPiece(new Soldier(49,Side.WHITE));
        builder.setPiece(new Tank(48,Side.WHITE));
        builder.setPiece(new Hound(46,Side.WHITE));
        builder.setPiece(new Soldier(45,Side.WHITE));
        builder.setPiece(new Soldier(44,Side.WHITE));
        builder.setPiece(new Hound(43,Side.WHITE));
        builder.setMoveMaker(Side.WHITE);

        return builder.build();
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
