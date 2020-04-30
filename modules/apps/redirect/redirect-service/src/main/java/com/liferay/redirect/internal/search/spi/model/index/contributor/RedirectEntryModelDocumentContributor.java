/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.liferay.redirect.model.RedirectEntry;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.redirect.model.RedirectEntry",
	service = ModelDocumentContributor.class
)
public class RedirectEntryModelDocumentContributor
	implements ModelDocumentContributor<RedirectEntry> {

	@Override
	public void contribute(Document document, RedirectEntry redirectEntry) {
		document.setSortableTextFields(
			new String[] {"destinationURL", "sourceURL"});

		document.addText("destinationURL", redirectEntry.getDestinationURL());
		document.addDateSortable(
			"lastOccurrenceDate", redirectEntry.getLastOccurrenceDate());
		document.addText("sourceURL", redirectEntry.getSourceURL());
	}

}