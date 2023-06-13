package csu07419.tictactoe;

import java.util.Scanner;

public class TicTacToeApp {
   public static  int ROWS = 5;
   public static  int COLUMNS = 8;
   public static void main(String[] args) {
char currentPlayer = 'X';
boolean gameEnded = false;
        PlayBoard playBoard= new PlayBoard(ROWS,COLUMNS);
       Scanner scn =new Scanner(System.in);
       while (!gameEnded){

    System.out.println("Player " + currentPlayer + "'s turn.");
    boolean validMove = false;
            while (!validMove){

                System.out.println(currentPlayer+" Please enter your Row\n");
            int Row=scn.nextInt();
            System.out.println(currentPlayer+" Please enter your Column\n");
            int Column =scn.nextInt();

                TokenPosition tk1 =new TokenPosition( Row, Column);
                if(playBoard.checkFreeSpace(tk1)){
                    playBoard.placeToken(tk1,currentPlayer);
                    validMove=true;

                }else{
                    System.out.println("The Space is Unavailable, please pick again");
                    continue ;
                }
                if(playBoard.checkWinner(new TokenPosition(Row,Column))){
                    System.out.println(playBoard);
                    System.out.println("Player "+ currentPlayer+ " wins!");
                    gameEnded=true;
                } else if (playBoard.checkTie()) {
                    System.out.println(playBoard);
                    System.out.println("The game has ended in a draw");
                    gameEnded=true;
                }else {
                    System.out.println(playBoard);
                    if(currentPlayer=='X'){
                        currentPlayer='O';
                    }else {
                        currentPlayer='X';
                    }
                }
            }

}

       System.out.println("Do you want to play again? (Y/N)");
       String playAgain = scn.next();
       if (playAgain.equalsIgnoreCase("Y")) {
           main(null);
       } else {
           System.out.println("Thank you for playing Tic-Tac-Toe!");
       }

       scn.close();

    }

}