package lt.daujotas.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lt.daujotas.Users.clientData.ClientData;

public class PasswordMatchValidator implements ConstraintValidator<RepeatPassword, ClientData> {



    @Override
    public boolean isValid(ClientData clientData, ConstraintValidatorContext constraintValidatorContext) {
       return clientData.getPassword().equals((clientData.getRepeatPassrowd()));
    }
}
