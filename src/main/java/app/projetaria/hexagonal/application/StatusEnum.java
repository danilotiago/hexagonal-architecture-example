package app.projetaria.hexagonal.application;

public enum StatusEnum {
	ENABLE("enable"),
	DISABLE("disable");
	
	private String description;
	
	StatusEnum(String description) {
		this.description = description;
	}
	
	public String getStatus() {
		return this.description;
	}
	
	public Boolean isValid(String description) {
		for (StatusEnum item : StatusEnum.values()) {
			if (description.equals(item.getStatus())) {
				return true;
			}
		}
		return false;
	}
}
