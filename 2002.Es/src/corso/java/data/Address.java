package corso.java.data;

public abstract class Address {
	private boolean work;

	public Address() {
	}

	public Address(boolean isWork) {
		this.setWork(isWork);
	}

	public boolean isWork() {
		return work;
	}

	public void setWork(boolean isWork) {
		this.work = isWork;
	}

	@Override
	public String toString() {
		return String.format("Address(isWork=%s)", work);
	}

}
