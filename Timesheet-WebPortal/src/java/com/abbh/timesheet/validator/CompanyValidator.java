/*
 * CompanyValidator.java
 *
 * Created on Aug 14, 2007, 11:59:01 PM
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abbh.timesheet.validator;

import com.abbh.timesheet.dto.CompanyDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author shannan
 */
public class CompanyValidator implements Validator {

    public boolean supports(Class clazz) {
        return CompanyDTO.class.isAssignableFrom(clazz);
    }

    public void validate(Object obj, Errors errors) {
        CompanyDTO companydto = (CompanyDTO) obj;
        validateId(companydto, errors);
        validateName(companydto, errors);
        validateType(companydto, errors);
        validateCity(companydto, errors);
    }

    public void validateId(CompanyDTO companyDTO, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "id", "ID_REQUIRED", "ID is required.");
    }

    public void validateName(CompanyDTO companyDTO, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "Name_REQUIRED", "Name is required.");
    }

    public void validateType(CompanyDTO companyDTO, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "type", "TYPE_REQUIRED", "Type is required.");
    }

    public void validateCity(CompanyDTO companyDTO, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "city", "CITY_REQUIRED", "City is required.");
    }


    public CompanyValidator() {
    }
}
