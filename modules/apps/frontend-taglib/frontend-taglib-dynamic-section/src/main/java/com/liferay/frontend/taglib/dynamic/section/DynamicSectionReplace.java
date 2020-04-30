/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.dynamic.section;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.jsp.PageContext;

/**
 * @author Matthew Tambara
 */
public interface DynamicSectionReplace {

	public String replace(PageContext pageContext)
		throws IOException, ServletException;

}