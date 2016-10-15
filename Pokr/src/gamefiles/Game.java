package gamefiles;

import java.util.Scanner;

import players.User;

public class Game {

	public Scanner input = new Scanner(System.in);
	
	public void startGame(){
		System.out.println("Hello and welcome to Pokr, a text based Texas Hold'em Poker Game.\nThis game is brought to you by KingArthur & MisterSteen.\n\nPlease enter a username:");
		boolean username = false;
		while (username==false) {
			String input = this.input.nextLine();
			if (input.trim().equals("") || input.isEmpty()) {
				System.out.println("This username is not available.");
			} else {
				User User = new User(input);
				username = true;
			}
		}
		boolean difficulty = false;
		System.out.println("What kind of poker player are you?");
		while (difficulty==false) {
			System.out.println("Please choose: Beginner, Adept,Professional, Legend");
			String input = this.input.nextLine().toLowerCase();
			switch (input){
			case "beginner": 
				difficulty = true;
				startBeginner();
				System.out.println("work in progress");
				break;
			case "adept":
				difficulty = true;
				startAdept();
				System.out.println("work in progress");
				break;
			case "professional":
				difficulty = true;
				startProffesional();
				System.out.println("work in progress");
				break;
			case "legend":
				difficulty = true;
				startLegend();
				System.out.println("work in progress");
				break;
			}
				
		}
	}

	private void startLegend() {
		System.out.println("Legend");		
	}

	private void startProffesional() {
		System.out.println("Professional");
		
	}

	private void startAdept() {
		System.out.println("Adept");
		
	}

	private void startBeginner() {
		System.out.println("Beginner");
		
	}

}
