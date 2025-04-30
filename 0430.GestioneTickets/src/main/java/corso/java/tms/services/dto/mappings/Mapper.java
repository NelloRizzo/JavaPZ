package corso.java.tms.services.dto.mappings;

public interface Mapper<S, D> {
	public D map(S source);
}
