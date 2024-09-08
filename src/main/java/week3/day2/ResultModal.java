package week3.day2;

public class ResultModal {

	private String number;
	private String sys_id;
	private String short_description;
	private String opened_at;
	private CallerId caller_id;
	private String description;
	private String category;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSys_id() {
		return sys_id;
	}

	public void setSys_id(String sys_id) {
		this.sys_id = sys_id;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getOpened_at() {
		return opened_at;
	}

	public void setOpened_at(String opened_at) {
		this.opened_at = opened_at;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public CallerId getCaller_id() {
		return caller_id;
	}

	public void setCaller_id(CallerId caller_id) {
		this.caller_id = caller_id;
	}

}