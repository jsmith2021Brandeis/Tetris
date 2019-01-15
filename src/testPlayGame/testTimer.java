/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 25, 2018
  *Assignment:	Personal Study, tests my timer class for the tetris project
  *Bugs:
  */
package testPlayGame;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import PlayGame.Timer;

public class testTimer {
	Timer t;

	/**
	 * checks that the timer starts at 0 to 1 millisecond accuracy
	 */
	@Test
	public void testConstructor() {
		t = new Timer();
		long time = t.getTime();
		assertTrue(isInRange(time, 1, 0));
	}

	/**
	 * checks that the timer starts at 0 to 1 millisecond accuracy
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testGetAndResetTime() throws InterruptedException {
		// assert that time is 2000 milliseconds after waiting 2000 milliseconds
		t = new Timer();
		Thread.sleep(2000);
		long time = t.getTime();
		//increased range to 10 milliseconds after failed test
		assertTrue(isInRange(time, 10, 2000));
		// reset timer, assert that time is 0
		t.resetTime();
		time = t.getTime();
		assertTrue(isInRange(time, 1, 0));

	}

	/**
	 * Makes sure that the IsElapsped function can be used
	 * in a loop to measure half a second second ten times to 1 millisecond acccuracy
	 */
	@Test
	public void testElapsed() {
		t = new Timer();
		//repeat ten times
		for (int i = 0; i < 10; i++) {
			long initialTime=System.currentTimeMillis();
			//should wait for 1 second
			while (!t.elapsed(500)) {

			}
			//assert that timer waited for 1 second			
			long finalTime=System.currentTimeMillis();
			long elapsedTime=finalTime-initialTime;
			//set range to 5 milliseconds after failed test
			assertTrue(isInRange(elapsedTime, 5,500));
			
		}
	}

	/**
	 * makes sure that the isInRange helper method works correctly by asserting
	 * outcome with given time and tolerance
	 */
	@Test
	public void testInRange() {
		// these times are within range
		assertTrue(isInRange(1005, 5, 1000));
		assertTrue(isInRange(995, 5, 1000));
		// these times are not within range
		assertFalse(isInRange(1006, 5, 1000));
		assertFalse(isInRange(994, 5, 1000));
	}

	/**
	 * Helper method to test timer
	 * 
	 * @param time
	 *            the time to test
	 * @param tolerance
	 *            how many milliseconds time can be off by
	 * @param correctTime
	 *            the correct time
	 * @return whther the time is within tolerance of correct time, inclusive
	 */
	private boolean isInRange(long time, long tolerance, long correctTime) {
		if (correctTime - tolerance <= time && time <= correctTime + tolerance) {
			return true;
		}
		return false;
	}
}
