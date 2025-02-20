package corso.java.data;

import java.util.Arrays;

public class Contact {
	private String firstName;
	private String lastName;
	private String nickname;
	private Address[] addresses;

	public Contact(String firstName, String lastName, String nickname, Address[] addresses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.addresses = addresses;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Address[] getAddresses() {
		return addresses;
	}

	public void setAddresses(Address[] addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return String.format("Contact(firstName=%s, lastName=%s, nickname=%s, addresses=%s)", firstName, lastName,
				nickname, Arrays.toString(addresses));
	}

}
