/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.digital.signature.model.field.builder;

import com.liferay.digital.signature.model.field.RadioDSField;
import com.liferay.digital.signature.model.field.RadioGroupDSField;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface RadioGroupDSFieldBuilder
	extends UserEntryDSFieldBuilder<RadioGroupDSField> {

	public RadioGroupDSFieldBuilder addRadioDSField(RadioDSField radioDSField);

	public RadioGroupDSFieldBuilder addRadioDSFields(
		RadioDSField... radioDSFields);

	public RadioGroupDSFieldBuilder setGroupName(String groupName);

}