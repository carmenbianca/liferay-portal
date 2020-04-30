/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.soy.renderer;

import com.liferay.portal.kernel.template.TemplateException;

import java.io.IOException;
import java.io.Writer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Iván Zaera Avellón
 */
public interface SoyComponentRenderer {

	public void renderSoyComponent(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			ComponentDescriptor componentDescriptor, Map<String, ?> context)
		throws IOException, TemplateException;

	public void renderSoyComponent(
			HttpServletRequest httpServletRequest, Writer writer,
			ComponentDescriptor componentDescriptor, Map<String, ?> context)
		throws IOException, TemplateException;

}