package example.boot.entity;

import org.springframework.stereotype.Component;

@Component
public class InputEntity {

	private String message;

	private String deletekey;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeletekey() {
		return deletekey;
	}

	public void setDeletekey(String deletekey) {
		this.deletekey = deletekey;
	}

}
