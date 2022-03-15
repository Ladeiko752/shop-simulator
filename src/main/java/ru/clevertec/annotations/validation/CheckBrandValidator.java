package ru.clevertec.annotations.validation;
import ru.clevertec.annotations.CheckBrand;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.FileWriter;
import java.io.IOException;

public class CheckBrandValidator implements ConstraintValidator<CheckBrand, String> {
    private String brandValidator;

    @Override
    public void initialize(CheckBrand constraintAnnotation) {
        brandValidator = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.matches(brandValidator)){
            return true;
        }else{
            try(FileWriter writer = new FileWriter("valid.txt", true))
            {
                writer.write("An error occurred while validating this field: " + s);
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
