package game.tictactoe;

import java.util.Scanner;

public class Gameplay {
    Player player0,player1;
    Board board;
    int turn = 0;
    public Gameplay(){
        this.player0 = new Player(0);
        this.player1 = new Player(1);
        newGame();
    }
    private void newGame(){
        player0.changeTurn();
        player1.changeTurn();
        this.board = new Board();
        play();
        //board.showBoard();
    }
    private void play(){
        board.showBoard();
        int movePos = getMove();
        if(movePos==0){
            showMessage(901);
            play();
        }
        else if(board.makeMove(movePos,turn)){
            int result = board.checkForEnd(movePos,turn);
            if(result==0){
                this.turn = this.turn == 0 ? 1 : 0;
                play();
            }
            else{
                gameResult(result);
            }
        }
        else{
            showMessage(902);
            play();
        }
    }
    private void gameResult(int result){
        if(result==1){
            if(player0.turn == turn){
                player0.won++;
                player1.lost++;
            }
            else{
                result=2;
                player1.won++;
                player0.lost++;
            }
        }
        else{
            player0.draw++;
            player1.draw++;
        }
        showMessage(result);
        playAgain();
    }
    private int getMove(){
        String nameText = player0.turn==turn ? player0.name : player1.name;
        System.out.println(nameText+"'s turn");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()){
            int movePos = scanner.nextInt();
            if(movePos > 0 && movePos <= Math.pow(board.n,2)){
                return movePos;
            }
        }
        return 0;
    }
    private void showMessage(int code){
        switch (code){
            case 1:
                System.out.println(player0.name+" won!");
                break;
            case 2:
                System.out.println(player1.name+" won!");
                break;
            case 3:
                System.out.println("It's a draw!");
                break;
            case 901:
                System.out.println("Input out of range");
                break;
            case 902:
                System.out.println("This spot is already taken");
                break;
        }
    }
    private void playAgain(){
        player0.showStats();
        player1.showStats();
        System.out.println("Do you want to play again? (t/n)");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().equals("t")){
            newGame();
        }
        else{
            System.out.println("Thanks for playing!");
        }
    }
}
