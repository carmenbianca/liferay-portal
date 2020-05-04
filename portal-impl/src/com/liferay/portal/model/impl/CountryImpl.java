/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.CountryConstants;

import java.util.Locale;

/**
 * @author Brian Wing Shun Chan
 * @author Hugo Huijser
 */
@JSON(strict = true)
public class CountryImpl extends CountryBaseImpl {

	@Override
	public String getName(Locale locale) {
		String name = LanguageUtil.get(
			locale, CountryConstants.NAME_PREFIX + getName());

		if (!name.startsWith(CountryConstants.NAME_PREFIX)) {
			return name;
		}

		return getName();
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		return getName(getLocale(_nameCurrentLanguageId));
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	private String _nameCurrentLanguageId;

}