package com.ayush.ladersnake;

import java.util.List;

public class RollDiceandPlay implements Runnable {
	Dice dice;
	Integer currentPositionofGoti = 0;
	List<NumberBox> lstNumberBox;
	private volatile static boolean  exit =false; 
	private static String opened1st;
	private static String openendSecond;

	public RollDiceandPlay(Dice dice, List<NumberBox> lstNumberBox) {

		this.dice = dice;
		currentPositionofGoti = 0;
		this.lstNumberBox = lstNumberBox;
		

	}

	@Override
	public void run() {
		
		while (!exit && !(this.currentPositionofGoti == 100)) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Integer displayNumber = this.dice.getDisplayNumber();
			
			if (displayNumber == 6 && opened1st == null) // Game started
			{
				//System.out.println(Thread.currentThread().getName() + "opened" + this.lstNumberBox.hashCode());
				opened1st = Thread.currentThread().getName();
			} else if (displayNumber == 6 && opened1st != null 
					&& Thread.currentThread().getName().compareTo(opened1st) != 0) {
				//System.out.println(Thread.currentThread().getName() + "opened   " + this.lstNumberBox.hashCode());
				openendSecond = Thread.currentThread().getName();
			}
			synchronized (this.dice) {
				if (opened1st != null && Thread.currentThread().getName().compareTo(opened1st) == 0) {
					try {
						//System.out.println("In wait first sync   "+ Thread.currentThread().getName()+ opened1st);
						//this.dice.notifyAll();
						this.dice.wait(1000);
						displayNumber = this.dice.getDisplayNumber();
						NumberBox box = this.lstNumberBox.get(this.currentPositionofGoti);
						if (box.getLadderPresent()) {
							System.out.println("Lader at :) " + box.getNumber() + "value" +box.getLaderTerminatingNumber() );
							this.currentPositionofGoti = box.getLaderTerminatingNumber();
						} else if (box.getSnakePresent()) {
							System.out.println("Snake at :( " + box.getNumber() + "value" +box.getSnakeTerminatingNumber() );
							this.currentPositionofGoti = box.getSnakeTerminatingNumber();
						} else {
							if(this.currentPositionofGoti + displayNumber == 100) {
								System.out.println(Thread.currentThread().getName() + "WON");
								exit=true;
								break;
							}
							this.currentPositionofGoti = this.currentPositionofGoti + displayNumber < 100 ? this.currentPositionofGoti + displayNumber  : this.currentPositionofGoti ;
						}

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				this.dice.notify();

			}

			synchronized (this.dice) {
				if (opened1st != null &&  !(Thread.currentThread().getName().compareTo(opened1st) == 0)) {
					if (openendSecond != null && Thread.currentThread().getName().compareTo(openendSecond) == 0) {
						
					try {
						//System.out.println("In wait second sync" + Thread.currentThread().getName()+ openendSecond);
						//this.dice.notifyAll();
						this.dice.wait(1000);
						displayNumber = this.dice.getDisplayNumber();
						NumberBox box = this.lstNumberBox.get(this.currentPositionofGoti);
						if (box.getLadderPresent()) {
							System.out.println("Lader at :) " + box.getNumber() + "value" +box.getLaderTerminatingNumber() );
							this.currentPositionofGoti = box.getLaderTerminatingNumber();
						} else if (box.getSnakePresent()) {
							System.out.println("Snake at :( " + box.getNumber() + "value "+box.getSnakeTerminatingNumber() );
							this.currentPositionofGoti = box.getSnakeTerminatingNumber();
						} else {
							if(this.currentPositionofGoti + displayNumber == 100) {
								System.out.println(Thread.currentThread().getName() + "WON");
								exit=true;
								break;
							}
							this.currentPositionofGoti = this.currentPositionofGoti + displayNumber < 100 ? this.currentPositionofGoti + displayNumber  : this.currentPositionofGoti ;
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
				this.dice.notify();

			}

			System.out.println(Thread.currentThread().getName() + " got dice value as    " + this.currentPositionofGoti);
		}

	}

}
