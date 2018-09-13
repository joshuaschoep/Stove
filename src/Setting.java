
/**
 * Handles available setting values for Burner class
 * 4 values with integer and string representations, 0-4
 * @author josh schoep and abby dalke
 *
 */
public enum Setting {
	OFF (0, "[---]"),
	LOW (1, "[--+]"),
	MEDIUM (2, "[-++]"),
	HIGH (3, "[+++]");
	private String setting;
	private int value;
	

	private Setting(int value, String setting) {
		this.value = value;
		this.setting = setting;
	}

	public int getValue() {
		return value;
	}
	
	public String toString() {
		return setting;
	}
	
}
