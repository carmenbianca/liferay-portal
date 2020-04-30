/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.web.internal.info.display.contributor;

import com.liferay.info.display.contributor.InfoDisplayContributor;
import com.liferay.journal.model.JournalArticleConstants;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = InfoDisplayContributor.class)
public class DefaultJournalArticleInfoDisplayContributor
	extends JournalArticleInfoDisplayContributor {

	@Override
	public String getInfoURLSeparator() {
		return JournalArticleConstants.CANONICAL_URL_SEPARATOR;
	}

}