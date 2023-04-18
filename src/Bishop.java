public class Bishop extends ChessPiece{
    public Bishop(String color){
        super(color);
    }
    public String getSymbol(){
        return "B";
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line,
                                     int column, int toLine, int toColumn){
        if( !chessBoard.checkPos( toLine)) return false;
        if( !chessBoard.checkPos( toColumn)) return false;

        for( int k = -1; k < 2; k += 2)
            for (int l = -1; l < 2; l += 2)
                for( int i = 1; i < 8; i++ ){
                    int currLine = toLine + k * i, currCol = toColumn + l * i;
                    if( !chessBoard.checkPos(currLine) || !chessBoard.checkPos(currCol)) break;
                    if( line == currLine && column == currCol ){
                        if( chessBoard.board[toLine][toColumn] == null ){
                            for( int j = i - 1; j > 0; j--) {
                                int line1 = line - k * j, col1 = column - l * j;
                                if (chessBoard.board[line1][col1] != null)
                                    return false;
                            }
                            return true;
                        } else
                            return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                    }
                }
        return false;
    }
}