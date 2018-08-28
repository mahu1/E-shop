package matti.eshop.controller;

import matti.eshop.service.UserDto;

import org.apache.commons.validator.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserDtoValidator implements Validator {

	@Override
	public boolean supports(Class cls) {
		return UserDto.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "", "Etunimi-kenttä on tyhjä.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "", "Sukunimi-kenttä on tyhjä.");

		UserDto dto = (UserDto) obj;

		if(dto.getUserName() != null) {
			if(dto.getUserName().length() < 5 || !dto.getUserName().matches("[a-öA-Ö1-9]*")) {
				errors.rejectValue("userName", "", "Virheellinen käyttäjätunnus " +
						"(käyttäjätunnuksen on oltava vähintään 5 merkkiä ja siinä ei saa olla erikoismerkkejä).");
			}
		}
		if(dto.getPassword().length() < 5 || !dto.getPassword().matches("[a-öA-Ö1-9]*")) {
			errors.rejectValue("password", "", "Virheellinen salasana " +
					"(salasanan on oltava vähintään 5 merkkiä ja siinä ei saa olla erikoismerkkejä).");
		}
		if(!dto.getPassword().equals(dto.getPassword2())) {
			errors.rejectValue("password", "", "Syötetty salasana ja sen varmennus eivät ole samat.");
		}
		if(!dto.getFirstName().matches("[a-öA-Ö]*")) {
			errors.rejectValue("firstName", "", "Virheellinen etunimi.");
		}
		if(!dto.getLastName().matches("[a-öA-Ö]*")) {
			errors.rejectValue("lastName", "", "Virheellinen sukunimi.");
		}
		if(dto.getAddress().length() < 3) {
			errors.rejectValue("address", "", "Virheellinen lähiososite.");
		}
		if((dto.getZipCode().length() != 5 || !dto.getZipCode().matches("[0-9]*"))) {
			errors.rejectValue("zipCode", "", "Virheellinen postinumero.");
		}
		if(!dto.getHomeTown().matches("[a-öA-Ö]*") || dto.getHomeTown().length() < 1) {
			errors.rejectValue("homeTown", "", "Virheellinen postitoimipaikka.");
		}
		if((dto.getAreaCode().length() < 2 || !dto.getAreaCode().matches("[0-9]*"))) {
			errors.rejectValue("areaCode", "", "Virheellinen suuntanumero.");
		}
		if((dto.getPhoneNumber().length() < 5 || !dto.getPhoneNumber().matches("[0-9]*"))) {
			errors.rejectValue("phoneNumber", "", "Virheellinen puhelinnumero.");
		}
		if(!EmailValidator.getInstance().isValid(dto.getMail())) {
			errors.rejectValue("mail", "", "Virheellinen sähköpostiosoite.");
		}
	}

}
