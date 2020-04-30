/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.internal.model.field;

import com.liferay.digital.signature.model.field.DSField;
import com.liferay.digital.signature.model.field.UserEntryDSField;

/**
 * @author Michael C. Han
 */
public abstract class UserEntryDSFieldImpl<T extends DSField<?>>
	extends StyledDSFieldImpl<T> implements UserEntryDSField<T> {

	public UserEntryDSFieldImpl(
		String documentKey, String fieldKey, Integer pageNumber) {

		super(documentKey, fieldKey, pageNumber);
	}

	@Override
	public Boolean getConcealValue() {
		return _concealValue;
	}

	@Override
	public Boolean getDisableAutoSize() {
		return _disableAutoSize;
	}

	@Override
	public Integer getMaxLength() {
		return _maxLength;
	}

	@Override
	public String getOriginalValue() {
		return _originalValue;
	}

	@Override
	public Boolean getRequireInitialOnSharedChange() {
		return _requireInitialOnSharedChange;
	}

	@Override
	public String getValidationMessage() {
		return _validationMessage;
	}

	@Override
	public String getValidationRegex() {
		return _validationRegex;
	}

	@Override
	public String getValue() {
		return _value;
	}

	public void setConcealValue(Boolean concealValue) {
		_concealValue = concealValue;
	}

	public void setDisableAutoSize(Boolean disableAutoSize) {
		_disableAutoSize = disableAutoSize;
	}

	public void setMaxLength(Integer maxLength) {
		_maxLength = maxLength;
	}

	public void setOriginalValue(String originalValue) {
		_originalValue = originalValue;
	}

	public void setRequireInitialOnSharedChange(
		Boolean requireInitialOnSharedChange) {

		_requireInitialOnSharedChange = requireInitialOnSharedChange;
	}

	public void setValidationMessage(String validationMessage) {
		_validationMessage = validationMessage;
	}

	public void setValidationRegex(String validationRegex) {
		_validationRegex = validationRegex;
	}

	public void setValue(String value) {
		_value = value;
	}

	private Boolean _concealValue;
	private Boolean _disableAutoSize;
	private Integer _maxLength;
	private String _originalValue;
	private Boolean _requireInitialOnSharedChange;
	private String _validationMessage;
	private String _validationRegex;
	private String _value;

}