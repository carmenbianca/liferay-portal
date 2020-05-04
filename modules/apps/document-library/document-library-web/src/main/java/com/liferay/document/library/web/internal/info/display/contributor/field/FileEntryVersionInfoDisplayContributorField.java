/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.info.display.contributor.field;

import com.liferay.info.display.contributor.field.InfoDisplayContributorField;
import com.liferay.info.display.contributor.field.InfoDisplayContributorFieldType;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(
	property = "model.class.name=com.liferay.portal.kernel.repository.model.FileEntry",
	service = InfoDisplayContributorField.class
)
public class FileEntryVersionInfoDisplayContributorField
	implements InfoDisplayContributorField<FileEntry> {

	@Override
	public String getKey() {
		return "version";
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(
			ResourceBundleUtil.getBundle(locale, getClass()), "version");
	}

	@Override
	public InfoDisplayContributorFieldType getType() {
		return InfoDisplayContributorFieldType.TEXT;
	}

	@Override
	public String getValue(FileEntry fileEntry, Locale locale) {
		return fileEntry.getVersion();
	}

}