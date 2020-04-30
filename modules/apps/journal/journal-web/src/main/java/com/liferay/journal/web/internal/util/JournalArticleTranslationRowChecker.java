/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.util;

import com.liferay.portal.kernel.dao.search.RowChecker;

import javax.portlet.PortletResponse;

/**
 * @author Pavel Savinov
 */
public class JournalArticleTranslationRowChecker extends RowChecker {

	public JournalArticleTranslationRowChecker(
		PortletResponse portletResponse) {

		super(portletResponse);
	}

	@Override
	public boolean isChecked(Object obj) {
		if (obj instanceof JournalArticleTranslation) {
			JournalArticleTranslation articleTranslation =
				(JournalArticleTranslation)obj;

			if (articleTranslation.isDefault()) {
				return false;
			}
		}

		return super.isDisabled(obj);
	}

	@Override
	public boolean isDisabled(Object obj) {
		if (obj instanceof JournalArticleTranslation) {
			JournalArticleTranslation articleTranslation =
				(JournalArticleTranslation)obj;

			return articleTranslation.isDefault();
		}

		return super.isDisabled(obj);
	}

}