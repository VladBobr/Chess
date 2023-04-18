abstract class ChessPiece{
    protected String color;
    protected boolean check;
    public ChessPiece(String color){
        this.color = color;
        check = true;
    }
    public String getColor(){
        return color;
    }
    abstract boolean canMoveToPosition(ChessBoard chessBoard, int line,
                                       int column, int toLine, int toColumn);
    abstract String getSymbol();
}