/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.captcha;

import com.liferay.dynamic.data.mapping.form.field.type.BaseDDMFormFieldType;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldType;

import org.osgi.service.component.annotations.Component;

/**
 * @author Marcellus Tavares
 */
@Component(
	immediate = true,
	property = {
		"ddm.form.field.type.js.class.name=Liferay.DDM.Field.Captcha",
		"ddm.form.field.type.js.module=liferay-ddm-form-field-captcha",
		"ddm.form.field.type.name=captcha", "ddm.form.field.type.system=true"
	},
	service = DDMFormFieldType.class
)
public class CaptchaDDMFormFieldType extends BaseDDMFormFieldType {

	@Override
	public String getModuleName() {
		return "dynamic-data-mapping-form-field-type/Captcha/Captcha.es";
	}

	@Override
	public String getName() {
		return "captcha";
	}

}