/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.liferay.redirect.model.RedirectNotFoundEntry;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.redirect.model.RedirectNotFoundEntry",
	service = ModelDocumentContributor.class
)
public class RedirectNotFoundEntryModelDocumentContributor
	implements ModelDocumentContributor<RedirectNotFoundEntry> {

	@Override
	public void contribute(
		Document document, RedirectNotFoundEntry redirectNotFoundEntry) {

		document.addText(Field.URL, redirectNotFoundEntry.getUrl());
		document.addNumber("hits", redirectNotFoundEntry.getHits());
		document.addKeyword("ignored", redirectNotFoundEntry.isIgnored());
	}

}