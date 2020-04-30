/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.render;

import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Pablo Carvalho
 */
public interface DDMFormFieldRenderer {

	public String[] getSupportedDDMFormFieldTypes();

	public String render(
			DDMFormField ddmFormField,
			DDMFormFieldRenderingContext ddmFormFieldRenderingContext)
		throws PortalException;

}