/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.values.factory;

import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;

import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Marcellus Tavares
 */
public interface DDMFormValuesFactory {

	public DDMFormValues create(
		HttpServletRequest httpServletRequest, DDMForm ddmForm);

	public DDMFormValues create(PortletRequest portletRequest, DDMForm ddmForm);

}