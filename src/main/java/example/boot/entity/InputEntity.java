package example.boot.entity;

import org.springframework.stereotype.Component;

@Component
public class InputEntity {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
