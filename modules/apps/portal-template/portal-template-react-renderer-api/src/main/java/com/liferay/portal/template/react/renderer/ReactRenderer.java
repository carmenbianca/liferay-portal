/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.react.renderer;

import java.io.IOException;
import java.io.Writer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Chema Balsas
 */
public interface ReactRenderer {

	public void renderReact(
			ComponentDescriptor componentDescriptor, Map<String, Object> data,
			HttpServletRequest httpServletRequest, Writer writer)
		throws IOException;

}