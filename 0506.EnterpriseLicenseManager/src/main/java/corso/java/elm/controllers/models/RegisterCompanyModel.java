package corso.java.elm.controllers.models;

import lombok.Data;

@Data
public class RegisterCompanyModel {
	private String name;
	private String address;
	private String email;
	private String vat;
}
