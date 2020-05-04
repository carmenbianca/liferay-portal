/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.internal.search.spi.model.index.contributor;

import com.liferay.depot.model.DepotEntry;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.depot.model.DepotEntry",
	service = ModelDocumentContributor.class
)
public class DepotEntryModelDocumentContributor
	implements ModelDocumentContributor<DepotEntry> {

	@Override
	public void contribute(Document document, DepotEntry depotEntry) {
		Group group = _groupLocalService.fetchGroup(depotEntry.getGroupId());

		document.addText(Field.DESCRIPTION, group.getDescription());
		document.addDate(Field.MODIFIED_DATE, depotEntry.getModifiedDate());
		document.addText(Field.NAME, group.getName());

		for (Locale locale :
				LanguageUtil.getAvailableLocales(depotEntry.getGroupId())) {

			String languageId = LocaleUtil.toLanguageId(locale);

			document.addText(
				LocalizationUtil.getLocalizedName(
					Field.DESCRIPTION, languageId),
				group.getDescription(locale));
			document.addText(
				LocalizationUtil.getLocalizedName(Field.NAME, languageId),
				group.getName(locale));
		}
	}

	@Reference
	private GroupLocalService _groupLocalService;

}