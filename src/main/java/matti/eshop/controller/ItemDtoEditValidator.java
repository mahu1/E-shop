package matti.eshop.controller;

import java.math.BigDecimal;

import matti.eshop.service.ItemSaveDto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ItemDtoEditValidator implements Validator {

	@Override
	public boolean supports(Class cls) {
		return ItemSaveDto.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ItemSaveDto dto = (ItemSaveDto) obj;
		
		if(dto.getTitle().length() < 4) {
			errors.rejectValue("title", "", "Liian lyhyt otsikko (otsikon on oltava vähintään 4 merkkiä).");
		}
		
		if(dto.getPrice() == null) {
			errors.rejectValue("price", "", "Hinta-kenttä on tyhjä.");
		}
		else {
			System.out.println(dto.getPrice());
			if(dto.getPrice().compareTo(new BigDecimal("0.1")) == -1 || dto.getPrice().compareTo(new BigDecimal("1000000")) == 1) {
				errors.rejectValue("price", "", "Virheellinen hinta.");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "", "Kuvaus-kenttä on tyhjä.");
	}

}
