/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.info.display.contributor.field;

import com.liferay.document.library.util.DLURLHelper;
import com.liferay.info.display.contributor.field.InfoDisplayContributorField;
import com.liferay.info.display.contributor.field.InfoDisplayContributorFieldType;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	property = "model.class.name=com.liferay.portal.kernel.repository.model.FileEntry",
	service = InfoDisplayContributorField.class
)
public class FileEntryPreviewImageInfoDisplayContributorField
	implements InfoDisplayContributorField<FileEntry> {

	@Override
	public String getKey() {
		return "previewImage";
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(
			ResourceBundleUtil.getBundle(locale, getClass()), "preview-image");
	}

	@Override
	public InfoDisplayContributorFieldType getType() {
		return InfoDisplayContributorFieldType.IMAGE;
	}

	@Override
	public Object getValue(FileEntry fileEntry, Locale locale) {
		try {
			return JSONUtil.put(
				"alt", fileEntry.getTitle()
			).put(
				"url", _dlURLHelper.getImagePreviewURL(fileEntry, null)
			);
		}
		catch (Exception exception) {
			return null;
		}
	}

	@Reference
	private DLURLHelper _dlURLHelper;

}