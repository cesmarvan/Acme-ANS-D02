
package acme.entities.claim;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidMoment;
import acme.constraints.ValidLongText;
import acme.entities.leg.Leg;
import acme.realms.AssistanceAgent;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Claim extends AbstractEntity {

	// Version
	private static final long	serialVersionUID	= 1L;

	// Attributes
	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				registrationMoment;

	@Mandatory
	@ValidEmail
	@Automapped
	private String				email;

	@Mandatory
	@ValidLongText
	@Automapped
	private String				description;

	@Mandatory
	@Valid
	@Automapped
	private ClaimType			type;

	@Mandatory
	@Valid
	@Automapped
	private Boolean				indicator;

	// Relationships
	@Mandatory
	@Valid
	@ManyToOne(optional = true)
	private AssistanceAgent		assistanceAgent;

	@Mandatory
	@Valid
	@ManyToOne(optional = true)
	private Leg					leg;

}
