package lt.daujotas.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lt.daujotas.dto.ClientDto;

import java.util.Objects;

public class PasswordMatchValidator implements ConstraintValidator<RepeatPassword, ClientDto> {



    @Override
    public boolean isValid(ClientDto clientDto, ConstraintValidatorContext constraintValidatorContext) {
       return Objects.nonNull(clientDto.getPassword()) && clientDto.getPassword().equals(clientDto.getRepeatPassword());
    }
}
