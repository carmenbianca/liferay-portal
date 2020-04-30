/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.soy.internal.util;

import com.liferay.portal.template.soy.renderer.SoyComponentRenderer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Iván Zaera Avellón
 */
@Component(immediate = true, service = {})
public class SoyComponentRendererProvider {

	public static SoyComponentRenderer getSoyComponentRenderer() {
		if (_soyRendererProvider == null) {
			return null;
		}

		return _soyRendererProvider._soyComponentRenderer;
	}

	public SoyComponentRendererProvider() {
		_soyRendererProvider = this;
	}

	private static SoyComponentRendererProvider _soyRendererProvider;

	@Reference
	private SoyComponentRenderer _soyComponentRenderer;

}