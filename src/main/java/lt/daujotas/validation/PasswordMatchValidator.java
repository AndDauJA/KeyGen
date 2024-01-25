package lt.daujotas.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.Email;
import lt.daujotas.Users.dto.ClientDto;

import java.lang.annotation.Annotation;

public class PasswordMatchValidator implements ConstraintValidator<RepeatPassword, ClientDto> {



    @Override
    public boolean isValid(ClientDto clientDto, ConstraintValidatorContext constraintValidatorContext) {
       return clientDto.getPassword().equals((clientDto.getRepeatPassrowd()));
    }
}
