/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.web.internal.servlet.taglib.ui;

import com.liferay.asset.list.constants.AssetListFormConstants;
import com.liferay.asset.list.model.AssetListEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.taglib.ui.BaseJSPFormNavigatorEntry;

import java.util.Locale;

/**
 * @author Eduardo García
 */
public abstract class BaseAssetListFormNavigatorEntry
	extends BaseJSPFormNavigatorEntry<AssetListEntry> {

	@Override
	public String getCategoryKey() {
		return StringPool.BLANK;
	}

	@Override
	public String getFormNavigatorId() {
		return AssetListFormConstants.FORM_NAVIGATOR_ID;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, getKey());
	}

}