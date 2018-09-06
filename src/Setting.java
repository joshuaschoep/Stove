
public enum Setting {
	OFF ("---"),
	LOW ("--+"),
	MEDIUM ("-++"),
	HIGH ("+++");
	private String setting;
	

	private Setting(String setting) {
		this.setting = setting;
	}


	public String toString() {
		return setting;
	}
	
}
