package corso.java.elm.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@SuperBuilder(setterPrefix = "with")
@ToString(callSuper = true)
public class PurchasedLicenseDto extends BaseDto {
	private String activationKey;
	private CompanyDto company;
	private LicenseDto license;
	private SoftwareDto software;
	private LocalDateTime purchasedAt;
	private LocalDateTime expiresAt;
}
