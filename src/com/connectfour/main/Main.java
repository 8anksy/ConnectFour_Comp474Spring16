package com.connectfour.main;

import java.util.Scanner;

import com.connectfour.model.Board;
import com.connectfour.view.Boot;

public class Main {

	public static void main(String[] args) {
		
		System.err.println("Main start...");

		Board board = new Board();
		System.err.println("Board initialized...");
		
		Scanner input = new Scanner(System.in);
		System.err.println("Scanner initialized...");
		
		
		playConnectFour(input, board);
		
		
	}

	private static void playConnectFour(Scanner input, Board board) {
		
		System.err.println("Game started...");
		
		board.initializeBoard();
		
		
		// This variable will alternate and mean whose turn is it. It is Red's turn now.
        //boolean isRed = true;
        String value = " ";
        Boot game = new Boot(board);
        game.playGame();
        /*while (true) {
        	
        	System.out.println("Please type \"reset\" to restart the game anytime!");
            if (board.currentColor=='R')
                System.out.println("Red's turn now!");            
            else 
                System.out.println("Black's turn now!");
            System.out.print("Pick a spot from column 1 to 7:");
            value = input.next();
            if (value.equalsIgnoreCase("reset")) {
            	break;
            }
            int column = Integer.parseInt(value);
            if (column < 1 || column > 7) {
                System.out.println("Column should be from 1 to 7");
                continue;
            }
            if (!board.putColorChar(column - 1, board.currentColor)) {
                System.out.println("This column is filled! Choose another one.");
                continue;
            }
            
            WinCheck winCheck = new WinCheck(board);
            char result = winCheck.getWinner(board);
            if (result == 'D') {
                System.out.println("It is a draw!");
                //board.isFinished=true;
                break;
            }
            else if (result == 'R') {
                System.out.println("Red wins!");
                //board.isFinished=true;
                break;
            }
            else if (result == 'B') {
                System.out.println("Black wins!");
                //board.isFinished=true;
                break;
            }

            board.printBoard();
            
            
            isRed = !isRed;
            
            
        }*/
        
        if (value.equalsIgnoreCase("reset")) {
        	playConnectFour(input, board);
        }
	}
}
