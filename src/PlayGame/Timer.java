package PlayGame;
/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 19, 2018December 19 2018
  *Assignment: Personal Study, implements a timer to use in reading user input	
  *Bugs:
  */

public class Timer {
	private long start;
	/**
	 * creates a new timer object, sets start time to current system time
	 */
	public Timer() {
		resetTime();
	}
	
	/**
	 * 
	 * @return time elapsed since last reset
	 */
	public long getTime() {
		return System.currentTimeMillis()-start;
	}

	/**
	 *resets the timer
	 */
	public void resetTime() {
		start=System.currentTimeMillis();
	}
	
	/**
	 * 
	 * @param elapsed the amount of time to elapse in milliseconds
	 * @return whether that time has elapsed
	 */
	public boolean elapsed(long goal) {
		if (getTime()<goal) {
			return false;
		}else {
			resetTime();
			return true;
		}
		
		
	}
}
