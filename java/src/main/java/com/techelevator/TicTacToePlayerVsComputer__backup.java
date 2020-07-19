package com.techelevator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
//import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToePlayerVsComputer__backup {
	static Scanner in;
	static String[] board;
	static String turn;
	//static int numInputPrint=0;
	static int numInput=0;

	public static void main(String[] args) {
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
		
			//int numInput=0;
			//String numInputString = in.nextLine();

			if (turn.equals("X")) {
				boolean enterLoop = true;
				String numInputString = in.nextLine();
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
			}
			else if(turn.equals("O")) {
				//computer go on the offense first to try and win: by checking if there are 2 'Os' in a row,column, or diagnal
				computerPlay("OO");
				if(ComputerMove.offenseOrDefense) {
					numInput = ComputerMove.boardPosition;
				}
				
				//if after computer go on offense and can't get a win, then go on defense to see if are
				//2 'Xs' in a row, colum, or diagonal. If has it, then computer tries to stop it, or stop user from winning
				else {
					computerPlay("XX");
				//if(ComputerMove.offenseOrDefense) {
					numInput = ComputerMove.boardPosition;
				//}
				}
				
			}
			
			///numInputPrint = numInput;
			//this if statement check to see if the slot on the board is a number (in String format)
			//if the array slot on the board is a number, then the slot is empty therefore permit the player to put an X or O on it
			//if the board[number-1] doesn't have a number, but instead have an X or O on it, then the slot is already taken (need to go to the else statement below)
			if (board[numInput-1].equals(String.valueOf(numInput))) { 
				board[numInput-1] = turn; //placing an X or O on the empty table slot
				//re-assign the turn either to X or O, so as to take turn
				if (turn.equals("X")) { //'X' turn to go
					turn = "O";
				} else { //'O' turn to go
					
					turn = "X";
				}
				printBoard();
				winner = checkWinner(); //if winner is not null, and Winner equal 'X' or 'O', then exit out of this loop
			} else {
				System.out.println(board[numInput-1] +", " + (numInput) + ": Slot already taken; re-enter slot number:");
				continue; //keep continuing playing 
			}
		}
		
		//after the winner loop above is done, the checkWinner method would return either a draw or a winner is return (X or O winner)
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		} else {
			System.out.println(winner + "'s have won! Thanks for playing.");
		}
	}

	
	//static Map<Integer, Boolean> computerPlay(String attackOrDefense) {
	  static void computerPlay(String attackOrDefense) {
		
			boolean flagAttackOrDefense = false; //start out with flag for attack or defense as false
			ComputerMove.offenseOrDefense=false; //start out with attack or defense as false

			
			if((board[0]+board[1]).equals(attackOrDefense) && board[2].equals("3")) {
				//return 2;
				flagAttackOrDefense = true;
				//boardPosition.put(2,flagAttackOrDefense);
				//return boardPosition;
				ComputerMove.setBoardPosition(3);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[1]+board[2]).equals(attackOrDefense) && board[0].equals("1")) {
				//return 0;
				flagAttackOrDefense = true;
				//boardPosition.put(0,flagAttackOrDefense);
				ComputerMove.setBoardPosition(1);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[0]+board[2]).equals(attackOrDefense) && board[1].equals("2")) {
				//return 1;
				flagAttackOrDefense = true;
				//boardPosition.put(1,flagAttackOrDefense);
				ComputerMove.setBoardPosition(2);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[3]+board[4]).equals(attackOrDefense) && board[5].equals("6")) {
				//return 5;
				flagAttackOrDefense = true;
				//boardPosition.put(5,flagAttackOrDefense);
				ComputerMove.setBoardPosition(6);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[4]+board[5]).equals(attackOrDefense) && board[3].equals("4")) {
				//return 3;
				flagAttackOrDefense = true;
				//boardPosition.put(3,flagAttackOrDefense);
				ComputerMove.setBoardPosition(4);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[3]+board[5]).equals(attackOrDefense) && board[4].equals("5")) {
				//return 4;
				flagAttackOrDefense = true;
				//boardPosition.put(4,flagAttackOrDefense);
				ComputerMove.setBoardPosition(5);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[6]+board[7]).equals(attackOrDefense) && board[8].equals("9")) {
				//return 8;
				flagAttackOrDefense = true;
				//boardPosition.put(8,flagAttackOrDefense);
				ComputerMove.setBoardPosition(9);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[7]+board[8]).equals(attackOrDefense) && board[6].equals("7")) {
				//return 6;
				flagAttackOrDefense = true;
				//boardPosition.put(6,flagAttackOrDefense);
				ComputerMove.setBoardPosition(7);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[6]+board[8]).equals(attackOrDefense) && board[7].equals("8")) {
				//return 7;
				flagAttackOrDefense = true;
				//boardPosition.put(7,flagAttackOrDefense);
				ComputerMove.setBoardPosition(8);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[0]+board[3]).equals(attackOrDefense) && board[6].equals("7")) {
				//return 6;
				flagAttackOrDefense = true;
				//boardPosition.put(6,flagAttackOrDefense);
				ComputerMove.setBoardPosition(7);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[3]+board[6]).equals(attackOrDefense) && board[0].equals("1")) {
				//return 0;
				flagAttackOrDefense = true;
				//boardPosition.put(0,flagAttackOrDefense);
				ComputerMove.setBoardPosition(1);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[0]+board[6]).equals(attackOrDefense) && board[3].equals("4")) {
				//return 3;
				flagAttackOrDefense = true;
				//boardPosition.put(3,flagAttackOrDefense);
				ComputerMove.setBoardPosition(4);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[1]+board[7]).equals(attackOrDefense) && board[4].equals("5")) {
				//return 4;
				flagAttackOrDefense = true;
				//boardPosition.put(4,flagAttackOrDefense);
				ComputerMove.setBoardPosition(5);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[1]+board[4]).equals(attackOrDefense) && board[7].equals("8")) {
				//return 7;
				flagAttackOrDefense = true;
				//boardPosition.put(7,flagAttackOrDefense);
				ComputerMove.setBoardPosition(8);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[4]+board[7]).equals(attackOrDefense) && board[1].equals("2")) {
				//return 1;
				flagAttackOrDefense = true;
				//boardPosition.put(1,flagAttackOrDefense);
				ComputerMove.setBoardPosition(2);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[2]+board[5]).equals(attackOrDefense) && board[8].equals("9")) {
				//return 8;
				flagAttackOrDefense = true;
				//boardPosition.put(8,flagAttackOrDefense);
				ComputerMove.setBoardPosition(9);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[5]+board[8]).equals(attackOrDefense) && board[2].equals("3")) {
				//return 2;
				flagAttackOrDefense = true;
				//boardPosition.put(2,flagAttackOrDefense);
				ComputerMove.setBoardPosition(3);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[2]+board[8]).equals(attackOrDefense) && board[5].equals("6")) {
				//return 5;
				flagAttackOrDefense = true;
				//boardPosition.put(5,flagAttackOrDefense);
				ComputerMove.setBoardPosition(6);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[6]+board[2]).equals(attackOrDefense) && board[4].equals("5")) {
				//return 4;
				flagAttackOrDefense = true;
				//boardPosition.put(4,flagAttackOrDefense);
				ComputerMove.setBoardPosition(5);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[6]+board[4]).equals(attackOrDefense) && board[2].equals("3")) {
				//return 8;
				flagAttackOrDefense = true;
				//boardPosition.put(8,flagAttackOrDefense);
				ComputerMove.setBoardPosition(3);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[2]+board[4]).equals(attackOrDefense) && board[6].equals("7")) {
				//return 6;
				flagAttackOrDefense = true;
				//boardPosition.put(6,flagAttackOrDefense);
				ComputerMove.setBoardPosition(7);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[4]+board[8]).equals(attackOrDefense) && board[0].equals("1")) {
				//return 6;
				flagAttackOrDefense = true;
				//boardPosition.put(6,flagAttackOrDefense);
				ComputerMove.setBoardPosition(1);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[0]+board[8]).equals(attackOrDefense) && board[4].equals("5")) {
				//return 2;
				flagAttackOrDefense = true;
				//boardPosition.put(2,flagAttackOrDefense);
				ComputerMove.setBoardPosition(5);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if((board[0]+board[4]).equals(attackOrDefense) && board[8].equals("9")) {
				//return 4;
				flagAttackOrDefense = true;
				//boardPosition.put(4,flagAttackOrDefense);
				ComputerMove.setBoardPosition(9);
				ComputerMove.setOffenseOrDefense(flagAttackOrDefense);
			}
			else if (attackOrDefense.equals("XX") && flagAttackOrDefense ==false) {
				Random rand = new Random();
				int upperbound = 9;
				String winner = null;
				int randomArrayIndexPosition = rand.nextInt(upperbound); //generate random array position 0 to 8;
				
				//winner = checkWinner();
				
				//check to see if the random board position is occupied with 'X' or 'O', and if there's a winner or a draw
				//if winner or a draw, then break out of the while loop
				//if no winner or no draw yet, keep trying to find a random board position that isn't occupied by X or O
				while(board[randomArrayIndexPosition].equals("X") || board[randomArrayIndexPosition].equals("O")) { //&& winner==null) {
					
					//winner = checkWinner();
					randomArrayIndexPosition = rand.nextInt(upperbound);
				}
				
				randomArrayIndexPosition ++; //increment this by 1, because the numInput (printed number value on the board) is larger by 1
				
				ComputerMove.setBoardPosition(randomArrayIndexPosition);
				
				//boardPosition.put(randomArrayIndexPosition,flagAttackOrDefense);
				//return randomArrayIndexPosition;
				
			}
			
			//return boardPosition;
			//return ComputerMove;

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

		if(turn.equals("X")) {
			System.out.println("\n>>>>COMPUTER'S PLAY: Computer had placed 'O' in slot number: " + numInput + " <<<<");
			System.out.println("\n" + turn + "'s turn (PLAYER'S TURN): please enter a slot number to place " + turn + " in:");
		}
		return null;
	}

	static void printBoard() {
		System.out.println("\n\n/---|---|---\\");
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


