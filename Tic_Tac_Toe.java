/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_tac_toe;

import java.util.*;


public class Tic_Tac_Toe {
    
    private char[][] board;
    private char currentPlayerMark;
    
    public Tic_Tac_Toe(){
      board = new char[3][3];
      currentPlayerMark = 'x';
      intializeBoard();
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Though process; Tic-Tac toe is a 3x3 game filled with X's and O's.
        // So i will need to define a 3x3 array 
        //user will return array position[0.0,0.1,0.2,1.0,1.1,1.2,2.0,2.1,2.2] and also the character that will be there {'X' or 'O')
        //Use a function call
        //Assign player a character: Player 1 ='X' Player 2 ='O'
        //Check for horizontal. vertical, and diagonal matching of characters.
        //Print array after each player entry
        //Do character check to make sure each player entered their own character
        //Find a way to eliminate positions when the user fills it. e.g if a user enter 0-1 as coordinates then it shouldnt' be an option for next time
        
        
       
       System.out.println("Start Playing Game");
       //makes a function call to playGame to start playing game
       Tic_Tac_Toe game = new Tic_Tac_Toe();
       
       Scanner scan = new Scanner(System.in);
        int row, col;
        //allows user to choose where to put their mark
        System.out.println("Enter a row cordinate: Options are 0-2");
        row = scan.nextInt();
        System.out.println("Enter column coordinate: Optons are 0-2");
        col = scan.nextInt();
        
        //places mark at the position
        game.placeMark(row,col);
        
        //prints the board
        game.printBoard();
        
        while(!game.checkForWin()){
            
            game.changePlayer();
            
            System.out.println("Enter a row cordinate: Options are 0-2");
            row = scan.nextInt();
            System.out.println("Enter column coordinate: Optons are 0-2");
            col = scan.nextInt();
        
            //places mark at the position
            game.placeMark(row,col);
            
            //prints the board
            game.printBoard();
            
            //game.changePlayer();
        }
        
        //check for winner
        if(game.checkForWin()){
            System.out.println("We have a winner!!!! CONGRATS!!");
            System.exit(0);
        }
        //checks if all index are filled
        else if(game.isFilled()){
            System.out.println("We have a draw!");
            System.exit(0);
        }
        /*if all indexes are not filled and there is no winner, change the player to
        continue playing. Switches player mark to 'o'*/
        //else
            
       
        
        
        
    }
    
    //set/reset the board back to all empty value
    public void intializeBoard(){
        for(int i=0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] ='-';
            }
        }
    }
    
    //Print the current board
    public  void printBoard(){
        System.out.println("-------------");
        
        for(int i=0; i<3; i++){
            System.out.print(" | ");
            for(int j=0; j<3; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
    //return a position decided by player and then player will enter X or O
   /* public static void playGame(){
        Scanner scan = new Scanner(System.in);
        int row, col;
        //allows user to choose where to put their mark
        System.out.println("Enter a row cordinate: Options are 0-2");
        row = scan.nextInt();
        System.out.print("Enter column coordinate: Optons are 0-2");
        col = scan.nextInt();
        
        //places mark at the position
        placeMark(row, col);
        
        //prints the board
        printBoard();
        
        //check for winner
        if(checkForWin()){
            System.out.println("We have a winner!!!! CONGRATS!!");
            System.exit(0);
        }
        //checks if all index are filled
        else if(isFilled()){
            System.out.println("We have a draw!");
            System.exit(0);
        }
        /*if all indexes are not filled and there is no winner, change the player to
        continue playing. Switches player mark to 'o'*/
        //else
            //changePlayer();
        
    //}
    
    //checks if the index the game at that row and col number is filled
    //returns true if index is filled, false otherwise
    public boolean isFilled(){
        boolean filled = true;
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[i][j] == '-')
                    filled = false;
            }
        }
        
        return filled;
    }
    
    //this checks of there is a winnner
    //returns true if there is a win, false otherwise
    public boolean checkForWin(){
        return (checkRowsForWin() || checkColForWin() || checkDiagonalForWin());
    }
    
    //loop thru rows to see if any is a win
    private boolean checkRowsForWin(){
        for(int i=0; i<3; i++){
            if(checkRowCol(board[i][0], board[i][1], board[i][2]) == true)
                return true;
        }
        return false;
    }
    
    //loop through columns to see if there is any win
    private boolean checkColForWin(){
        for(int i=0; i<3; i++){
             if(checkRowCol(board[0][i], board[1][i], board[2][i]) == true)
                return true;
        }
        return false;
    }
    
    //check the 2 diagonals to see if either create a win  
    private boolean checkDiagonalForWin(){
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));

    }
    
    //check values to see if they match and not empty
    private boolean checkRowCol(char c1, char c2, char c3){
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }
    
    //chnage player marker
    public  void changePlayer(){
        if(currentPlayerMark == 'x'){
            currentPlayerMark = 'o';
        }
        else
            currentPlayerMark = 'x';
    }
    
    //places a mark where specified by 
    public boolean placeMark(int row, int col){
        
        //checks if the position is within the bounds of the board.
        if((row >= 0) && (row <= 3)){
            if((col >= 0) && (row <= 3)){
                if(board[row][col] == '-'){
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }
        return false;
    }
    
}
