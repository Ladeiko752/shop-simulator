package ru.clevertec.annotations.validation;

import org.springframework.stereotype.Component;
import ru.clevertec.annotations.CheckPrice;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.FileWriter;
import java.io.IOException;

public class CheckPriceValidator implements ConstraintValidator<CheckPrice, Double> {

    private String priceValidator;

    @Override
    public void initialize(CheckPrice constraintAnnotation) {
        priceValidator = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Double aDouble, ConstraintValidatorContext constraintValidatorContext) {
        if (aDouble.toString().matches(priceValidator)) {
            return true;
        }else{
            try(FileWriter writer = new FileWriter("valid.txt", true))
            {
                writer.write("An error occurred while validating this field: " + aDouble);
                writer.append('\n');
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            return false;
        }
    }
}
