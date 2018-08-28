package matti.eshop.controller;

import matti.eshop.service.ItemSaveDto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class ItemDtoSaveValidator extends ItemDtoEditValidator {

	@Override
	public void validate(Object obj, Errors errors) {
		super.validate(obj, errors);
		
		ItemSaveDto dto = (ItemSaveDto) obj;

		if(dto.getLocationId() == 0) {
			errors.rejectValue("locationId", "", "Valitse sijainti.");
		}
		if(dto.getDepartmentId() == 0) {
			errors.rejectValue("departmentId", "", "Valitse osasto.");
		}
		if(dto.getSellingTime() < 1 || dto.getSellingTime() > 30) {
			errors.rejectValue("sellingTime", "", "Virheellinen aukioloaika (aukioloajan pitää olla 1-30 päivää).");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sellingTime", "", "Aukioloaika-kenttä on tyhjä.");
	}

}