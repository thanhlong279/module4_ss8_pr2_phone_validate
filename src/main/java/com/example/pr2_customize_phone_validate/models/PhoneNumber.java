package com.example.pr2_customize_phone_validate.models;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PhoneNumber implements Validator {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumber phoneNumber = (PhoneNumber) target;
        String number = phoneNumber.getNumber();
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty", "Số điện thoại không được để trống.");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("number", "number.length", "Độ dài số điện thoại phải từ 10 đến 11 ký tự.");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number", "number.startsWith", "Số điện thoại phải bắt đầu bằng số 0.");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches", "Số điện thoại chỉ được chứa các ký tự số.");
        }
    }
}