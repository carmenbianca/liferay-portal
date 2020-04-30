/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.servlet.taglib.ui;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.journal.web.internal.constants.JournalWebConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.taglib.ui.BaseJSPFormNavigatorEntry;

import java.util.Locale;

/**
 * @author Eudaldo Alonso
 */
public abstract class BaseJournalDDMStructureFormNavigatorEntry
	extends BaseJSPFormNavigatorEntry<DDMStructure> {

	@Override
	public String getCategoryKey() {
		return StringPool.BLANK;
	}

	@Override
	public String getFormNavigatorId() {
		return JournalWebConstants.FORM_NAVIGATOR_ID_JOURNAL_DDM_STRUCTURE;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, getKey());
	}

}