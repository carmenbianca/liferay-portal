/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.field.builder;

import com.liferay.digital.signature.model.field.DSField;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface UserEntryDSFieldBuilder<T extends DSField<?>>
	extends StyledDSFieldBuilder<T> {

	public <S> S setConcealValue(Boolean concealValue);

	public <S> S setDisableAutoSize(Boolean disableAutoSize);

	public <S> S setMaxLength(Integer maxLength);

	public <S> S setOriginalValue(String originalValue);

	public <S> S setRequireInitialOnSharedChange(
		Boolean requireInitialOnSharedChange);

	public <S> S setValidationMessage(String validationMessage);

	public <S> S setValidationRegex(String validationRegex);

	public <S> S setValue(String value);

}