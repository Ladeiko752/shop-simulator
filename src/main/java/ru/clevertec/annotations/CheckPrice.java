package ru.clevertec.annotations;

import org.intellij.lang.annotations.Language;
import ru.clevertec.annotations.validation.CheckPriceValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPriceValidator.class)
public @interface CheckPrice {
    @Language("RegExp")
    public String value();
    public String message() default "Value entered incorrectly!";

    public Class<?>[] groups() default {};
    public Class<? extends Payload> [] payload() default {};
}