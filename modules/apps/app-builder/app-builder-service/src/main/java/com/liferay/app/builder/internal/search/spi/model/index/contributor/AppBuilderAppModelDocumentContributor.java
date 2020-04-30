/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.internal.search.spi.model.index.contributor;

import com.liferay.app.builder.model.AppBuilderApp;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Gabriel Albuquerque
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.app.builder.model.AppBuilderApp",
	service = ModelDocumentContributor.class
)
public class AppBuilderAppModelDocumentContributor
	implements ModelDocumentContributor<AppBuilderApp> {

	@Override
	public void contribute(Document document, AppBuilderApp appBuilderApp) {
		document.addKeyword(
			"ddmStructureId", appBuilderApp.getDdmStructureId());

		String[] languageIds = getLanguageIds(
			appBuilderApp.getDefaultLanguageId(), appBuilderApp.getName());

		for (String languageId : languageIds) {
			document.addText(
				LocalizationUtil.getLocalizedName(Field.NAME, languageId),
				appBuilderApp.getName(languageId));
		}

		document.addLocalizedKeyword(
			"localized_name",
			LocalizationUtil.populateLocalizationMap(
				appBuilderApp.getNameMap(),
				appBuilderApp.getDefaultLanguageId(),
				appBuilderApp.getGroupId()),
			true, true);
	}

	protected String[] getLanguageIds(
		String defaultLanguageId, String content) {

		String[] languageIds = LocalizationUtil.getAvailableLanguageIds(
			content);

		if (languageIds.length == 0) {
			languageIds = new String[] {defaultLanguageId};
		}

		return languageIds;
	}

}