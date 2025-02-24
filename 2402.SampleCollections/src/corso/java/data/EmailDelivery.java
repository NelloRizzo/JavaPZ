package corso.java.data;

public class EmailDelivery extends Delivery {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("EmailDelivery(email=%s, isPreferred()=%s)", email, isPreferred());
	}

	public EmailDelivery() {
	}

	public EmailDelivery(String email) {
		super();
		this.email = email;
	}

	public EmailDelivery(String email, boolean preferred) {
		super();
		this.email = email;
		setPreferred(preferred);
	}

}
