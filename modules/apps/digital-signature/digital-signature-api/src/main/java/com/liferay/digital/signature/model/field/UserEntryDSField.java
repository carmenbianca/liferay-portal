/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.field;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface UserEntryDSField<T extends DSField<?>>
	extends StyledDSField<T> {

	public Boolean getConcealValue();

	public Boolean getDisableAutoSize();

	public Integer getMaxLength();

	public String getOriginalValue();

	public Boolean getRequireInitialOnSharedChange();

	public String getValidationMessage();

	public String getValidationRegex();

	public String getValue();

}