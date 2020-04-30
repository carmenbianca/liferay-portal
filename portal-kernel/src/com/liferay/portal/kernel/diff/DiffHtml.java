/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.diff;

import java.io.Reader;

/**
 * @author Julio Camarero
 */
public interface DiffHtml {

	public String diff(Reader source, Reader target) throws Exception;

	public String replaceStyles(String html);

}