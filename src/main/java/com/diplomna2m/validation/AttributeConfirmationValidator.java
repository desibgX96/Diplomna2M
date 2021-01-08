package com.diplomna2m.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.apache.commons.beanutils.BeanUtils;

public class AttributeConfirmationValidator implements ConstraintValidator <AttributeConfirmation, Object>{
	
	private String attribute;
	private String attributeConfirmation;
	
	@Override
	public void initialize(AttributeConfirmation attributeConfirmation) {
		this.attribute = attributeConfirmation.attribute();
		this.attributeConfirmation = attributeConfirmation.attributeConfirmation();
	}
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		boolean valid = false;
		try {
			Object valueAttribute = BeanUtils.getProperty(object, this.attribute);
			Object valueAttributeConfirmation = BeanUtils.getProperty(object, this.attributeConfirmation);
			
			valid = bothAreNull (valueAttribute, valueAttributeConfirmation)|| bothAreEqual (valueAttribute, valueAttributeConfirmation);
		}catch (Exception e) {
			throw new RuntimeException("Грешка при извличането на стойностите на атрибутите", e);
		}
		
		if (!valid) {
			context.disableDefaultConstraintViolation();
			String mensagem = context.getDefaultConstraintMessageTemplate();
			ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(mensagem);
			violationBuilder.addPropertyNode(attributeConfirmation).addConstraintViolation();
		}
		return valid;
	}
	
	private boolean bothAreEqual(Object valueAttribute, Object valueAttributeConfirmation) {
		return valueAttribute != null && valueAttribute.equals(valueAttributeConfirmation);
	}
	
	private boolean bothAreNull(Object valueAttribute, Object valueAttributeConfirmation) {
		return valueAttribute == null && valueAttributeConfirmation== null;
	}
}
