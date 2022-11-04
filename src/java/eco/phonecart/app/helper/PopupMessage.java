package eco.phonecart.app.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PopupMessage {

	public static String ERROR = "danger";
	public static String WARN = "warning";
	public static String SUCCESS = "success";

	private String type;
	private String content;
	private int delay;
	private String icon;

	public PopupMessage() {
	}

	public PopupMessage(String type, String content) {
		this.type = type;
		this.content = content;
		this.delay = -1;
		if (type.equals(ERROR)) {
			this.icon = "mdi mdi-alert";
		} else if (type.equals(WARN)) {
			this.icon = "mdi mdi-information";
		} else if (type.equals(SUCCESS)) {
			this.icon = "mdi mdi-check-circle";
		} else {
			this.icon = "mdi mdi-message-processing";
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDelay() {
		return delay == -1 ? 0 : delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public void addList(List<PopupMessage> listMessage) {
		if (this.delay == -1) {
			if (listMessage.isEmpty()) {
				this.setDelay(1);
				listMessage.add(this);
			} else {
				PopupMessage lastMessage = listMessage.get(listMessage.size() - 1);
				this.setDelay(lastMessage.getDelay() + 1);
				listMessage.add(this);
			}
		} else {
			listMessage.add(this);
		}
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	

}
