/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.search.spi.model.result.contributor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	property = "indexer.class.name=com.liferay.document.library.kernel.model.DLFolder",
	service = ModelSummaryContributor.class
)
public class DLFolderModelSummaryContributor
	implements ModelSummaryContributor {

	@Override
	public Summary getSummary(
		Document document, Locale locale, String snippet) {

		String prefix = Field.SNIPPET + StringPool.UNDERLINE;

		String title = document.get(prefix + Field.TITLE, Field.TITLE);
		String content = document.get(
			prefix + Field.DESCRIPTION, Field.DESCRIPTION);

		Summary summary = new Summary(title, content);

		summary.setMaxContentLength(200);

		return summary;
	}

}