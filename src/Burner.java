
public class Burner {
	public enum Temperature { BLAZING, HOT, WARM, COLD };
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	public static final int TIME_DURATION = 2;
	public Burner() {
		super();
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		timer = 0;
	}
	public void plusButton() {
		switch(mySetting) {
		case OFF:
			mySetting = Setting.LOW;
			timer += TIME_DURATION;
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
	public void minusButton() {
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
	public void updateTemperature() {
		if(timer == 0) {
			switch(mySetting) {
			case OFF:
				turnDownTemp();
				break;
			case LOW:
				switch(myTemperature) {
				case COLD:
					turnUpTemp();
					break;
				case HOT:
				case BLAZING:
					turnDownTemp();
					break;
				}
			case MEDIUM:
				switch(myTemperature) {
				case COLD:
				case WARM:
					turnUpTemp();
					break;
				case BLAZING:
					turnDownTemp();
					break;
				}
			case  HIGH:
				turnUpTemp();
			}
		}else {
			timer--;
		}
	}
	private void turnUpTemp() {
		// TODO Auto-generated method stub
		
	}
	private void turnDownTemp() {
		// TODO Auto-generated method stub
		
	}
				}
			}
		}
		
	}
	
	
	
	
	
}
