/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.internal.search.spi.model.index.contributor;

import com.liferay.data.engine.model.DEDataListView;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jeyvison Nascimento
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.data.engine.model.DEDataListView",
	service = ModelDocumentContributor.class
)
public class DEDataListViewModelDocumentContributor
	implements ModelDocumentContributor<DEDataListView> {

	@Override
	public void contribute(Document document, DEDataListView deDataListView) {
		document.addKeyword(
			"ddmStructureId", deDataListView.getDdmStructureId());

		String[] languageIds = getLanguageIds(
			deDataListView.getDefaultLanguageId(), deDataListView.getName());

		for (String languageId : languageIds) {
			document.addText(
				LocalizationUtil.getLocalizedName(Field.NAME, languageId),
				deDataListView.getName(languageId));
		}

		document.addLocalizedKeyword(
			"localized_name",
			LocalizationUtil.populateLocalizationMap(
				deDataListView.getNameMap(),
				deDataListView.getDefaultLanguageId(),
				deDataListView.getGroupId()),
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