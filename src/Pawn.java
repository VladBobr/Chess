public class Pawn extends ChessPiece{
    public Pawn(String color){
        super(color);
    }
    public String getColor(){
        return color;
    }
    public String getSymbol(){
        return "P";
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line,
                                     int column, int toLine, int toColumn){
        int dir = 1, baseLine = 1;
        if( !chessBoard.checkPos( toLine)) return false;
        if( !chessBoard.checkPos( toColumn)) return false;
        //if( toColumn != column ) return false;
        if(getColor().equals("Black")){
            dir = -1;
            baseLine = 6;
        }

        int currLine, currCol;

        currLine = line + dir*2; currCol = column;
        if( line == baseLine && toLine == line + dir*2 && toColumn == currCol){
            if( !chessBoard.checkPos(currLine) || !chessBoard.checkPos(currCol)) return false;
            if( chessBoard.board[line + dir][column] != null) return false;
            if( chessBoard.board[line + dir * 2][column] != null) return false;
            return true;
        }

        currLine = line + dir; currCol = column;
        if( toLine == line + dir && toColumn == column ){
            if( !chessBoard.checkPos(currLine) || !chessBoard.checkPos(currCol)) return false;
            if( chessBoard.board[line + dir][column] != null) return false;
            return true;
        }

        currLine = line + dir; currCol = column + 1;
        if( toLine == line + dir && toColumn == currCol ){
            if( !chessBoard.checkPos(currLine) || !chessBoard.checkPos(currCol)) return false;
            if( chessBoard.board[toLine][toColumn] != null)
                return !chessBoard.board[toLine][toColumn].getColor().equals(color);
        }

        currLine = line + dir; currCol = column - 1;
        if( toLine == line + dir && toColumn == currCol ){
            if( !chessBoard.checkPos(currLine) || !chessBoard.checkPos(currCol)) return false;
            if( chessBoard.board[toLine][toColumn] != null)
                return !chessBoard.board[toLine][toColumn].getColor().equals(color);
        }

        return false;
    }
}