/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.url.builder;

import javax.servlet.http.HttpServletRequest;

/**
 * Creates new Absolute Portal URL Builder instances.
 *
 * @author Iván Zaera Avellón
 */
public interface AbsolutePortalURLBuilderFactory {

	/**
	 * Returns a new Absolute Portal URL Builder instance tied to the given
	 * request.
	 *
	 * @param  httpServletRequest the servlet request
	 * @return an instance of Absolute Portal URL Builder
	 */
	public AbsolutePortalURLBuilder getAbsolutePortalURLBuilder(
		HttpServletRequest httpServletRequest);

}