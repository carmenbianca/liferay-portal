/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.renderer.internal.servlet.taglib;

import com.liferay.dynamic.data.mapping.form.renderer.internal.servlet.taglib.helper.BaseDDMFormFieldTypesDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bruno Basto
 */
@Component(immediate = true, service = DynamicInclude.class)
public class DDMFormRendererBottomDynamicInclude
	extends BaseDDMFormFieldTypesDynamicInclude {

	@Override
	public void include(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String key)
		throws IOException {

		Object value = httpServletRequest.getAttribute(
			DDMFormFieldTypesDynamicInclude.
				LIFERAY_SHARED_DDM_FORM_FIELD_TYPES_INCLUDED);

		if (value != null) {
			include(httpServletResponse);
		}

		httpServletRequest.removeAttribute(
			DDMFormFieldTypesDynamicInclude.
				LIFERAY_SHARED_DDM_FORM_FIELD_TYPES_INCLUDED);
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register("/html/common/themes/bottom.jsp#post");
	}

}