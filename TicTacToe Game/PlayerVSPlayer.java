package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class PlayerVSPlayer {
	
	static Scanner in;
	static String[] board;
	static String turn;
	
	
	public static void playTicTacToe() {
		
		in = new Scanner(System.in);
		board = new String[9];
		turn = "X";
		String winner = null;
		populateEmptyBoard();
		

		System.out.println("Welcome to 2 Player Tic Tac Toe.");
		System.out.println("--------------------------------");
		printBoard();
		System.out.println("X's will play first. Enter a slot number to place X in:");

		while (winner == null) {
			int numInput = 0;
			String numInputString = in.nextLine();

			//numInput = in.nextInt();
			boolean enterLoop = true;
			while (enterLoop) {
				try {
					//numInput = in.nextInt();
					numInput = Integer.parseInt(numInputString);
					if (!(numInput > 0 && numInput <= 9)) {
						System.out.println("Invalid input; re-enter slot number:");
						//continue;
						//numInput = in.nextInt();
						numInputString = in.nextLine();
					}
					else {
						enterLoop = false;
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid input; re-enter slot number:");
					//continue;
					//numInput = in.nextInt();
					numInputString = in.nextLine();
				}
			}
			
			//this if statement check to see if the slot on the board is a number (in String format)
			//if the array slot on the board is a number, then the slot is empty therefore permit the player to put an X or O on it
			//if the board[number-1] doesn't have a number, but instead have an X or O on it, then the slot is already taken (need to go to the else statement below)
			if (board[numInput-1].equals(String.valueOf(numInput))) { 
				board[numInput-1] = turn; //placing an X or O on the empty table slot
				//re-assign the turn either to X or O, so as to take turn
				if (turn.equals("X")) {
					turn = "O";
				} else {
					turn = "X";
				}
				printBoard();
				winner = checkWinner(); //if winner is not null, and Winner equal 'X' or 'O', then exit out of this loop
			} else {
				System.out.println("Slot already taken; re-enter slot number:");
				continue; //keep continuing playing 
			}
		}
		
		//after the winner loop above is done, the checkWinner method would return either a draw or a winner is return (X or O winner)
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
	}
	
	
	
	static String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			//this if statement loops through all the table slot & check to see if any of the slot on the board contain a number (in String format)..
			//if it does have it, then continue playing. But if all the slots either have X or O in them, 
			//then it's a draw (go to the else if statement below
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			//if cycle through all the array slot from index 0 to 8, and it contains all Xs and Os, but a winner is not yet return (above switch:case not return X or return O), then it's a draw.
			else if (a == 8) return "draw"; 
		}

		System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
		return null;
	}

	static void printBoard() {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("/---|---|---\\");
	}

	static void populateEmptyBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1); //at start of game, populate all slot on the empty board with number 1 to 9 (that are converted in String format) 
		}
	}
	
	
	

}
