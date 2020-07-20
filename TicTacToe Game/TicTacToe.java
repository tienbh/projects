package com.techelevator;

import java.util.Arrays;
import java.util.Random;
//import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
	static Scanner in;
	static String[] board;
	static String turn;

		
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter (1) for Player vs Computer mode, (2) Player vs Player mode, or (0) to Exit Game>>>\n");
		String stringInput = input.nextLine();
		
		while (!String.valueOf(stringInput).equals("1") && !String.valueOf(stringInput).equals("2") && !String.valueOf(stringInput).equals("0")) {
			System.out.println("Please enter (1) for Player vs Computer mode, (2) Player vs Player mode, or (0) to Exit Game\n");
			stringInput = input.nextLine();
		}
		
		if (String.valueOf(stringInput).equals("1")) {
			PlayerVSComputer.playTicTacToe();
		}
		else if (String.valueOf(stringInput).equals("2")) {
			PlayerVSPlayer.playTicTacToe();
		}
		else {
			System.out.println("GOODBYE!");
		}
		
		input.close();
		
	}
}


