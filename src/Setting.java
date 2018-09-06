
public enum Setting {
	OFF (0, "Off"),
	LOW (1, "Low"),
	MEDIUM (2, "Medium"),
	HIGH (3, "High");
	private int value;
	private String setting;
	

	private Setting(int value, String setting) {
		this.value = value;
		this.setting = setting;
	}


	public String toString() {
		return setting;
	}
	
}
