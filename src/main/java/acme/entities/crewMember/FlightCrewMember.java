
package acme.entities.crewMember;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.constraints.ValidIdentifier;
import acme.constraints.ValidLongText;
import acme.constraints.ValidPhoneNumber;
import acme.entities.airline.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightCrewMember extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@ValidIdentifier
	@Automapped
	private String				employeeCode;

	@Mandatory
	@ValidPhoneNumber
	@Automapped
	private String				phoneNumber;

	@Mandatory
	@ValidLongText
	@Automapped
	private String				languageSkills;

	@Mandatory
	@Enumerated(EnumType.STRING)
	@Automapped
	private AvailabilityStatus	status;

	@Mandatory
	@ValidNumber
	@Automapped
	private Integer				salary;

	@Optional
	@ValidNumber(min = 0)
	@Automapped
	private Integer				yearsOfExperience;

	@Mandatory
	@Valid
	@ManyToOne
	private Airline				airline;

}
