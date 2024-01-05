
public class Time {

	private int hour;
	private int minute;
	private int second;

	// Output as string
	public String toUniversalString() {
		return String.format("%2d : %2d : %2d", getHour(), getMinute(), getSecond());
	}

	// Output as string using AM and PM
	public String toString() {
		return String.format("%2d : %2d : %2d %s", (hour == 0 || hour == 12) ? 12 : hour % 12, minute, second,
				(hour < 12) ? "AM" : "PM");
	}

	/*
	 * Increase by 1 second
	 * and reset to 0 if it exceeds 60
	 * and call nextMinute()
	 */
	public void nextSecond() {
		second++;
		if (second >= 60) {
			second = 0;
			nextMinute();
		}
	}

	/*
	 * Increase by 1 minute
	 * and reset to 0 if it exceeds 60
	 * and call nextHour()
	 */
	public void nextMinute() {
		minute++;
		if (minute >= 60) {
			minute = 0;
			nextHour();
		}
	}
	
	/*
	 * Increase by 1 hour
	 * and reset to 0 if it exceeds 24
	 */
	public void nextHour() {
		hour++;
		if (hour >= 24) {
			hour = 0;
		}
	}

	/*
	 * Decrease by 1 second 
	 * and reset to 59 if it falls below 0
	 * and call previousMinute()
	 */
	public void previousSecond() {
		second--;
		if (second <= 0) {
			second = 59;
			previousMinute();
		}
	}

	/*
	 * Decrease by 1 minute 
	 * and reset to 59 if it falls below 0
	 * and call previousHour()
	 */
	public void previousMinute() {
		minute--;
		if (minute <= 0) {
			minute = 59;
			previousHour();
		}
	}

	/*
	 * Decrease by 1 hour 
	 * and reset to 23 if it falls below 0
	 */
	public void previousHour() {
		hour--;
		if (hour <= 0) {
			hour = 23;
		}
	}

	// Increase by 1 second
	public void tick() {
		nextSecond();
	}

	// Decrease by 1 second
	public void tickBack() {
		previousSecond();
	}

	// Initialize constructors by parameter
	public Time() {
		// this.hour = 0;
		// this.minute = 0;
		// this.second = 0;
		this(0, 0, 0);
	}

	public Time(Time t) {
		this.hour = t.hour;
		this.minute = t.minute;
		this.second = t.second;
	}

	public Time(int h) {
		// this.hour = h;
		// this.minute = 0;
		// this.second = 0;
		this(h, 0, 0);
	}

	public Time(int h, int m) {
		// this.hour = h;
		// this.minute = m;
		// this.second = 0;
		this(h, m, 0);
	}

	public Time(int h, int m, int s) {
		// this.hour = h;
		// this.minute = m;
		// this.second = s;
		setTime(h, m, s);
	}

	// Generate Getters and Setters for each variable
	public void setTime(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

}