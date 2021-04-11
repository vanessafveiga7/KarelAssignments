package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			move ();
			checkMiddleBeepers();
			cleanChads();
			checkMiddleBeepers();
		}
	}
	
	private void checkMiddleBeepers() {
		if (beepersPresent()) {
			move();
			move();
		} else {
			cleanChads(); 
		}
	}
	
	public void cleanChads() {
		cleanUp();
		cleanDown(); 
		move(); {
			if (frontIsClear()) {
				move();
				checkMiddleBeepers();
			}
		}
	}
	
	private void cleanUp() {
		turnLeft();
		move(); {
			if (beepersPresent()) {
			pickBeeper(); {
				while (beepersPresent()) {
					pickBeeper();
				}
			}
			turnAround();
			move();
			move();
			} else {
				turnAround();
				move();
				move();
			}
		}
	}
	
	private void cleanDown() {
		if (beepersPresent()) {
			pickBeeper(); {
				while (beepersPresent()) {
					pickBeeper();
				}
			}
			turnAround();
			move();
			turnRight();
		} else {
			turnAround();
			move();
			turnRight();
		}
	}
}
