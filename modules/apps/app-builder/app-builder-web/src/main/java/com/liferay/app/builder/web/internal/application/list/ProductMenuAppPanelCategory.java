/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.web.internal.application.list;

import com.liferay.application.list.BasePanelCategory;

import java.util.Dictionary;
import java.util.Locale;

/**
 * @author Jeyvison Nascimento
 */
public class ProductMenuAppPanelCategory extends BasePanelCategory {

	public ProductMenuAppPanelCategory(Dictionary properties) {
		_key = (String)properties.get("key");
		_label = (String)properties.get("label");
	}

	@Override
	public String getKey() {
		return _key;
	}

	@Override
	public String getLabel(Locale locale) {
		return _label;
	}

	private final String _key;
	private final String _label;

}