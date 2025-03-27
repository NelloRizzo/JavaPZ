package corso.java.fiscalcode.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class FiscalCodeResult {
	private PersonalData data;
	private String fiscalCode;
}
