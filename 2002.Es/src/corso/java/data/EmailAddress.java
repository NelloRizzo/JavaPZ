package corso.java.data;

public class EmailAddress extends Address {
	private String email;

	public EmailAddress(String email, boolean isWork) {
		super(isWork);
	}

	public EmailAddress(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("EmailAddress(email=%s, %s)", email, super.toString());
	}
}
