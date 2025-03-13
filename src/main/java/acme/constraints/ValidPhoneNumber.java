
package acme.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@ReportAsSingleViolation

@NotBlank
@Pattern(regexp = "^\\+?\\d{6,15}$")

public @interface ValidPhoneNumber {

	// Propiedades estándar de validación
	String message() default "{acme.validation.identifier.message}";

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
