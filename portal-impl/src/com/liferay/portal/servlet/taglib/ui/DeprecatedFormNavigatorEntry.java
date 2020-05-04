/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet.taglib.ui;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.taglib.ui.BaseJSPFormNavigatorEntry;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import java.util.Locale;

/**
 * @author Sergio González
 */
@OSGiBeanProperties
public class DeprecatedFormNavigatorEntry
	extends BaseJSPFormNavigatorEntry<Object> {

	public DeprecatedFormNavigatorEntry(
		String key, String label, String categoryKey, String formNavigatorId,
		String jspPath) {

		_key = key;
		_label = label;
		_categoryKey = categoryKey;
		_formNavigatorId = formNavigatorId;
		_jspPath = jspPath;
	}

	@Override
	public String getCategoryKey() {
		return _categoryKey;
	}

	@Override
	public String getFormNavigatorId() {
		return _formNavigatorId;
	}

	@Override
	public String getKey() {
		return _key;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, _label);
	}

	@Override
	protected String getJspPath() {
		return _jspPath;
	}

	private final String _categoryKey;
	private final String _formNavigatorId;
	private final String _jspPath;
	private final String _key;
	private final String _label;

}