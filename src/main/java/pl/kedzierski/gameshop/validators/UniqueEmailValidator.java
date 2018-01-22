package pl.kedzierski.gameshop.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kedzierski.gameshop.services.UserService;
import pl.kedzierski.gameshop.validators.annotations.UniqueEmail;
import pl.kedzierski.gameshop.validators.annotations.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserService userService;

    public void initialize(UniqueUsername constraint) {
    }

    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userService == null || (email != null && userService.isUniqueEmail(email));
    }

}