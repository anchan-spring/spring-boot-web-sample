package example.boot.entity;

import org.springframework.stereotype.Component;

@Component
public class InputEntity {

	private String message;

	private String deletekey;

	private String userId;
	private String firstName;
	private String lastName;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
