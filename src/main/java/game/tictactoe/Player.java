package game.tictactoe;

import java.util.Scanner;
public class Player {
    String name;
    int won, lost, draw;
    int turn;
    public Player(int turn){
        this.turn = turn;
        this.name = setName();
    }
    public String setName(){
        String turnText = this.turn == 0 ? "first" : "second";
        System.out.println("Enter "+turnText+" player's name");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public void showStats(){
        System.out.println(this.name+" - W:"+this.won+" L:"+this.lost+" D:"+this.draw);
    }
    public void changeTurn(){
        this.turn = this.turn == 0 ? 1 : 0;
    }
}
