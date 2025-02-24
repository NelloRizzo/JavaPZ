package corso.java.data;

public class PhoneDelivery extends Delivery {
	private String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneDelivery() {
	}

	public PhoneDelivery(String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}

	public PhoneDelivery(String phoneNumber, boolean preferred) {
		super();
		setPreferred(preferred);
		this.phoneNumber = phoneNumber;
	}

}
