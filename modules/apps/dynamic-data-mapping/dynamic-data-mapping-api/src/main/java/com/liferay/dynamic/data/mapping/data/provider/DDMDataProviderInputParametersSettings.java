/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.data.provider;

import com.liferay.dynamic.data.mapping.annotations.DDMForm;
import com.liferay.dynamic.data.mapping.annotations.DDMFormField;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Leonardo Barros
 */
@DDMForm
@ProviderType
public interface DDMDataProviderInputParametersSettings {

	@DDMFormField(label = "%label", properties = "placeholder=%enter-a-label")
	public String inputParameterLabel();

	@DDMFormField(
		label = "%parameter", properties = "placeholder=%enter-the-parameter"
	)
	public String inputParameterName();

	@DDMFormField(label = "%required", type = "checkbox")
	public boolean inputParameterRequired();

	@DDMFormField(
		label = "%type", optionLabels = {"%text", "%number"},
		optionValues = {"text", "number"}, type = "select"
	)
	public String inputParameterType();

}