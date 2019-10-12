package com.ayush.ladersnake;

import java.util.ArrayList;
import java.util.List;

public class LaderSnakeBoard {
	
	public  List<NumberBox> generateLaderSnakeBoard() {
		List<NumberBox> lstNumberBox = new ArrayList();
		for (int i = 1; i <= 100; i++) {
			NumberBox numb = new NumberBox();
			numb.setNumber(i);

			if (i == (int) (Math.random() * ((50 - 11) + 11)) + 1  || i == 13 || i==22 || i==29 || i==33 || i == 66 || i== 67 || i==81 || i== 88|| i==73 || i==42 || i==3) { // For lader

				numb.setLadderPresent(true);
				int k = (int) (Math.random() * (((90-i) - 1) + 1)) + 1;
				numb.setLaderTerminatingNumber((i + k) < 100 ? i + k : i );

				numb.setSnakePresent(false);
			} else if (i == (int) (Math.random() * ((99 - 20) + 20)) + 1 || i == 99 || i == 91 || i == 84 || i== 56 || i== 61 || i == 56 || i== 39 || i== 51|| i==18) {// for snake
				numb.setLadderPresent(false);
				numb.setSnakePresent(true);
				int k = (int) (Math.random() * (((i - 10) - 1) + 1)) + 1;
				numb.setSnakeTerminatingNumber((i - k) > 0 ? i - k : i);
			} else {
				numb.setSnakePresent(false);
				numb.setLadderPresent(false);
			}
			lstNumberBox.add(numb);

		}
		return lstNumberBox;
	}

}
