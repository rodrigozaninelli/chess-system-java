package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("Error instantiating ChessPosition. Vlaid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    //matrix_row = 8 - chess_row
    //'a'-'a' = 0
    //'b'-'a' = 1
    //'c'-'a' = 2
    //matris_column = chess_column - 'a'

    /*
    Matrix xadrex
    a1 = 0,0

    1 _ _ _ _ _ _ _ _
    2 _ _ _ _ _ _ _ _
    3 _ _ _ _ _ _ _ _
    4 _ _ _ _ _ _ _ _
    5 _ _ _ _ _ _ _ _
    6 _ _ _ _ _ _ _ _
    7 _ _ _ _ _ _ _ _
    8 _ _ _ _ _ _ _ _
      a b c d e f g h

     */
    //converte posição de xadres em uma posição de matrix normal = a1 = 0,0
    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
