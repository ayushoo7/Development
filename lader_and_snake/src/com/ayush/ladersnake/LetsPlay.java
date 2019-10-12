package com.ayush.ladersnake;

import java.util.List;

public class LetsPlay {

	public static void main(String[] args) {
		System.out.println("Lets Paly ladder and snake");
		LaderSnakeBoard ladersnakeBoard = new LaderSnakeBoard();
		List<NumberBox> generateLaderSnakeBoard = ladersnakeBoard.generateLaderSnakeBoard();
		Dice dice = new Dice();
		
		Thread user1= new Thread(new RollDiceandPlay(dice,generateLaderSnakeBoard),"User1");
		
		Thread user2= new Thread(new RollDiceandPlay(dice,generateLaderSnakeBoard),"User2");
		
		
		user1.start();
		user2.start();
		
		

	}

	
}
