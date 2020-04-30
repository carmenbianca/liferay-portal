/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.test.util.search;

import java.util.Locale;

/**
 * @author André de Oliveira
 */
public class GroupBlueprint {

	public Locale getDefaultLocale() {
		return _defaultLocale;
	}

	protected void setDefaultLocale(Locale defaultLocale) {
		_defaultLocale = defaultLocale;
	}

	private Locale _defaultLocale;

}