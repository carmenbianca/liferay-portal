/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.servlet;

import java.util.List;

import javax.servlet.ServletContext;

import org.osgi.framework.Bundle;

/**
 * @author Tina Tian
 */
public interface JSPTaglibHelper {

	public void scanTLDs(
		Bundle bundle, ServletContext servletContext,
		List<String> listenerClassNames);

}