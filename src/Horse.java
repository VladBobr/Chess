public class Horse extends ChessPiece{
    public Horse(String color){
        super(color);
    }
    public String getSymbol(){
        return "H";
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line,
                                     int column, int toLine, int toColumn){
        if( !chessBoard.checkPos( toLine)) return false;
        if( !chessBoard.checkPos( toColumn)) return false;


        int currLine, currCol;
        for( int k = -1; k < 2; k += 2)
            for (int l = -1; l < 2; l += 2) {
                currLine = line + 2 * k;
                currCol = column + l;
                if( !chessBoard.checkPos(currLine) || !chessBoard.checkPos(currLine)) continue;
                if( toLine ==  currLine && toColumn == currCol ) {
                    if (chessBoard.board[currLine][currCol] != null)
                        return !chessBoard.board[currLine][currCol].getColor().equals(color);
                    return true;
                }
            }

        for( int k = -1; k < 2; k += 2)
            for (int l = -1; l < 2; l += 2) {
                currLine = line + k;
                currCol = column + 2 * l;
                if( !chessBoard.checkPos(currLine) || !chessBoard.checkPos(currCol)) continue;
                if( toLine ==  currLine && toColumn == currCol ) {
                    if (chessBoard.board[currLine][currCol] != null)
                        return !chessBoard.board[currLine][currCol].getColor().equals(color);
                    return true;
                }
            }
        return false;
    }
}