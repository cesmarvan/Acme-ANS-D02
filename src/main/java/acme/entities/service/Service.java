
package acme.entities.service;

import javax.persistence.Column;
import javax.persistence.Entity;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import acme.constraints.ValidShortText;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Service extends AbstractEntity {

	@Mandatory
	@ValidShortText
	@Column(unique = true)
	private String	name;

	@Mandatory
	@ValidUrl
	@Automapped
	private String	pictureLink;

	@Mandatory
	@ValidNumber(min = 0)
	@Automapped
	private Double	avgDwellTime;

	@Optional
	@ValidString(pattern = "^[A-Z]{4}-[0-9]{2}$")
	@Automapped
	private String	promoCode;

	@Mandatory
	@ValidMoney
	@Automapped
	private Money	discount;

}
