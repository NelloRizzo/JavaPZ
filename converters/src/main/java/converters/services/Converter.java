package converters.services;

public interface Converter {
	String toBin(int number);

	String toHex(int number);

	String toOct(int number);

	int fromBin(String number);

	int fromHex(String number);

	int fromOct(String number);
}
