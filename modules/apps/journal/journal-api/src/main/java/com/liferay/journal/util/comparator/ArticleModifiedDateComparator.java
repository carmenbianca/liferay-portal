/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.util.comparator;

import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;
import com.liferay.journal.model.JournalArticle;

/**
 * @author Brian Wing Shun Chan
 */
public class ArticleModifiedDateComparator
	extends StagedModelModifiedDateComparator<JournalArticle> {

	public static final String ORDER_BY_ASC = "JournalArticle.modifiedDate ASC";

	public static final String ORDER_BY_DESC =
		"JournalArticle.modifiedDate DESC";

	public ArticleModifiedDateComparator() {
		this(false);
	}

	public ArticleModifiedDateComparator(boolean ascending) {
		super(ascending);
	}

	@Override
	public String getOrderBy() {
		if (isAscending()) {
			return ORDER_BY_ASC;
		}

		return ORDER_BY_DESC;
	}

}