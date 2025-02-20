package corso.java.data;

public class PhoneAddress extends Address {
	private String phoneNumber;

	public PhoneAddress(String phoneNumber, boolean isWork) {
		super(isWork);
		this.setPhoneNumber(phoneNumber);
	}

	public PhoneAddress(String phoneNumber) {
		super();
		this.setPhoneNumber(phoneNumber);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return String.format("PhoneAddress(phoneNumber=%s, %s)", phoneNumber, super.toString());
	}
}
