/**
 * Burner that keeps track of setting and temperature, with
 * timer and updater, as well as plus-setting and minus-setting buttons
 * @author josh schoep and abby dalke
 *
 */
public class Burner {
	/**
	 * Handles temperature values, has integer value 0-3 and 
	 * string values associated with different qualitative temperatures
	 * @author josh schoep and abby dalke
	 *
	 */
	public enum Temperature { 
		COLD(0, "cooool"),
		WARM(1, "warm"), 
		HOT(2, "CAREFUL"), 
		BLAZING(3, "VERY HOT! DON'T TOUCH");
		private String status;
		private int value;
		Temperature(int value, String status){
			this.value = value;
			this.status = status;
		}
		public int getValue() {
			return value;
		}
		public String toString() {
			return status;
		}
	};
	
	
	private Temperature myTemperature;
	private Setting mySetting;
	/**
	 * Each value represents one minute, counts down until the next
	 * temperature change
	 */
	private int timer;
	/**
	 * Duration of each heating/cooling step
	 */
	public static final int TIME_DURATION = 2;
	public Burner() {
		super();
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		timer = 0;
	}
	
	/**
	 * Increases setting by one, unless setting is already maximum
	 */
	public void plusButton() {
		if(timer == 0) {
			timer = TIME_DURATION;
		}
		switch(mySetting) {
		case OFF:
			mySetting = Setting.LOW;
			timer = TIME_DURATION;
			break;
		case LOW:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			break;
		default:
			break;
		}
	}
	
	/**
	 * Decreases setting by one, unless setting is OFF
	 */
	public void minusButton() {
		if(timer == 0) {
			timer = TIME_DURATION;
		}
		switch(mySetting) {
		case HIGH:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.OFF;
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * Handles timer variable as well as changes in temperature on update
	 */
	public void updateTemperature() {
		if(timer != 0) {
			timer--;
		}
		if(timer == 0) {
			if(myTemperature.getValue() < mySetting.getValue()) {
				turnUpTemp();
				timer = TIME_DURATION;
			}else if(myTemperature.getValue() > mySetting.getValue()) {
				turnDownTemp();
				timer = TIME_DURATION;
			}
		}
	}
	
	/**
	 * Turns temperature up from previous value, helper function for updateTemperature
	 */
	private void turnUpTemp() {
		switch(myTemperature) {
		case COLD: 
			myTemperature = Temperature.WARM;
			break;
		case WARM: 
			myTemperature = Temperature.HOT;
			break;
		case HOT:
			myTemperature = Temperature.BLAZING;
			break;
		default:
			break;
		}
	}
	
	/**
	 * Turns down temperature one value, helper function for updateTemperature
	 */
	private void turnDownTemp() {
		switch(myTemperature) {
		case BLAZING: 
			myTemperature = Temperature.HOT;
			break;
		case HOT:
			myTemperature = Temperature.WARM;
			break;
		case WARM: 
			myTemperature = Temperature.COLD;
			break;
		default:
			break;
		}	
	}
	
	/**
	 * Prints stove setting and temperature properly to console
	 */
	public void display() {
		System.out.println(mySetting + "....." + myTemperature + " " + timer);
	}
	
	public Temperature getMyTemperature() {
		return myTemperature;
	}
	
	
	
	
}
