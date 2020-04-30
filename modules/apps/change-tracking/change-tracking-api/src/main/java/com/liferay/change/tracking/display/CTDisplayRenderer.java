/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.display;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.change.tracking.CTModel;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Samuel Trong Tran
 */
public interface CTDisplayRenderer<T extends CTModel<T>> {

	public String getEditURL(HttpServletRequest httpServletRequest, T ctModel)
		throws Exception;

	public Class<T> getModelClass();

	public String getTypeName(Locale locale);

	public default String getTypeName(Locale locale, T ctModel)
		throws PortalException {

		return getTypeName(locale);
	}

	public void render(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, T ctModel)
		throws Exception;

}