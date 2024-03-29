package lt.daujotas.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneNumberValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    String message() default "Telefono numeris turi atitikti formatą +370";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    PhoneNumberType numberType() default PhoneNumberType.GLOBAL;
}
