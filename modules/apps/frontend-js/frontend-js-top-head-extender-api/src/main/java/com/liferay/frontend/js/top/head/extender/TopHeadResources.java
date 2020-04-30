/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.js.top.head.extender;

import java.util.Collection;

/**
 * @author Iván Zaera Avellón
 */
public interface TopHeadResources {

	public Collection<String> getAuthenticatedJsResourcePaths();

	public Collection<String> getJsResourcePaths();

	public String getServletContextPath();

}