/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.react.internal.util;

import com.liferay.portal.template.react.renderer.ReactRenderer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Chema Balsas
 */
@Component(service = {})
public class ReactRendererProvider {

	public static ReactRenderer getReactRenderer() {
		return _reactRenderer;
	}

	@Reference(unbind = "-")
	public void setReactRenderer(ReactRenderer reactRenderer) {
		_reactRenderer = reactRenderer;
	}

	private static ReactRenderer _reactRenderer;

}