/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.internal;

import com.liferay.portal.template.soy.data.SoyDataFactory;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Iván Zaera Avellón
 */
@Component(immediate = true, service = {})
public class SoyDataFactoryProvider {

	public static SoyDataFactory getSoyDataFactory() {
		if (_soyDataFactoryProvider == null) {
			return null;
		}

		return _soyDataFactoryProvider._soyDataFactory;
	}

	public SoyDataFactoryProvider() {
		_soyDataFactoryProvider = this;
	}

	private static SoyDataFactoryProvider _soyDataFactoryProvider;

	@Reference
	private SoyDataFactory _soyDataFactory;

}