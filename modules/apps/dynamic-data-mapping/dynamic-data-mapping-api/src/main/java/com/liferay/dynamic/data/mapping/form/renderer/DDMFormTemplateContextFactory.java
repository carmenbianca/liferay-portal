/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.renderer;

import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormLayout;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Map;

/**
 * @author Marcellus Tavares
 */
public interface DDMFormTemplateContextFactory {

	public Map<String, Object> create(
			DDMForm ddmForm, DDMFormLayout ddmFormLayout,
			DDMFormRenderingContext ddmFormRenderingContext)
		throws PortalException;

	public Map<String, Object> create(
			DDMForm ddmForm, DDMFormRenderingContext ddmFormRenderingContext)
		throws PortalException;

}