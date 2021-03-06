package pl.kedzierski.gameshop.validators.annotations;

import pl.kedzierski.gameshop.validators.UniqueEmailValidator;
import pl.kedzierski.gameshop.validators.UniqueUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
    String message() default "email not unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
