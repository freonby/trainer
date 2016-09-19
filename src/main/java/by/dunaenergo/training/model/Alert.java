package by.dunaenergo.training.model;

public class Alert {

	private String style;
	private String display;
	private String cause;
	private String alertMessage;

	public Alert(String style, String display, String cause, String alertMessage) {
		super();
		this.style = style;
		this.display = display;
		this.cause = cause;
		this.alertMessage = alertMessage;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}

}
