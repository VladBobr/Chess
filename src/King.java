public class King extends ChessPiece{
    public King(String color){
        super(color);
    }
    public String getSymbol(){
        return "K";
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line,
                                     int column, int toLine, int toColumn){
        if( !chessBoard.checkPos( toLine)) return false;
        if( !chessBoard.checkPos( toColumn)) return false;
        for( int i = -1; i < 2; i++ )
            for( int j = -1; j < 2; j++ ){
                if ( i == 0 && j == 0) continue;
                int currLine = line + i, currCol = column + j;
                if( !chessBoard.checkPos(currLine) || !chessBoard.checkPos(currCol)) continue;
                if( toLine == currLine && toColumn == currCol ){
                    if( chessBoard.board[currLine][currCol] != null )
                        return !chessBoard.board[currLine][currCol].getColor().equals(color);
                    if( isUnderAttack( chessBoard, toLine, toColumn) )
                        return false;
                    return true;
                }
            }
        return false;
    }
    public boolean isUnderAttack(ChessBoard board, int line, int column){
        for( int i = 0; i < 8; i++ )
            for( int j = 0; j < 8; j++ ){
                //if( i == line && j == column ) continue;
                if( board.board[i][j] == null ) continue;
                if( board.board[i][j].getColor().equals(this.getColor()) ) continue;
                if( board.board[i][j].canMoveToPosition( board, i, j, line, column))
                    return true;
            }
        return false;
    }
}