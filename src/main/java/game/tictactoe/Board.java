package game.tictactoe;

public class Board {
    public int n;
    private int possibleMoves;
    public int[][] board;
    public Board(){
        this.n = 3;
        possibleMoves = (int)Math.pow(this.n,2);
        this.board = cleanBoard();
    }
    public void showBoard(){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                String text = j==0 ? "|" : "";
                int sign = this.board[i][j];
                text+= sign==0 ? "o" : sign==-1 ? "X" : sign;
                System.out.print(text+"|");
            }
            System.out.println();
        }
    }
    public boolean makeMove(int movePos, int turn){
        int x,y;
        int sign = turn == 0? 0 : -1;
        movePos--;
        x = movePos/n;
        y = movePos%n;
        if(board[x][y]>0){
            board[x][y] = sign;
            possibleMoves--;
            return true;
        }
        return false;
    }
    public int checkForEnd(int movePos, int turn){
        int sign = turn == 0? 0 : -1;
        movePos--;
        int x = movePos/n;
        int y = movePos%n;
        for(int i = 0; i < n; i++){
            if(board[x][i] != sign)
                break;
            if(i == n-1){
                return 1;
            }
        }
        for(int i = 0; i < n; i++){
            if(board[i][y] != sign)
                break;
            if(i == n-1){
                return 1;
            }
        }
        if(x == y){
            for(int i = 0; i < n; i++){
                if(board[i][i] != sign)
                    break;
                if(i == n-1){
                    return 1;
                }
            }
        }
        if(x + y == n - 1){
            for(int i = 0; i < n; i++){
                if(board[i][(n-1)-i] != sign)
                    break;
                if(i == n-1){
                    return 1;
                }
            }
        }
        if(possibleMoves==0){
            return 3;
        }
        else{
            return 0;
        }
    }
    private int[][] cleanBoard(){
        int[][] board = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = i*n+j+1;
            }
        }
        return board;
    }
}
