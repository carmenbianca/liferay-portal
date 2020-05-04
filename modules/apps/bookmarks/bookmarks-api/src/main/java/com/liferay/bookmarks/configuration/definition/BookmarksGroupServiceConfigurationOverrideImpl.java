/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.configuration.definition;

import com.liferay.bookmarks.configuration.BookmarksGroupServiceConfigurationOverride;
import com.liferay.bookmarks.model.BookmarksFolderConstants;
import com.liferay.portal.kernel.settings.TypedSettings;
import com.liferay.portal.kernel.util.LocalizationUtil;

/**
 * @author Iván Zaera
 */
public class BookmarksGroupServiceConfigurationOverrideImpl
	implements BookmarksGroupServiceConfigurationOverride {

	public BookmarksGroupServiceConfigurationOverrideImpl(
		TypedSettings typedSettings) {

		_typedSettings = typedSettings;
	}

	@Override
	public String emailEntryAddedBodyXml() {
		return LocalizationUtil.getXml(
			_typedSettings.getLocalizedValuesMap("emailEntryAddedBody"),
			"emailEntryAddedBody");
	}

	@Override
	public String emailEntryAddedSubjectXml() {
		return LocalizationUtil.getXml(
			_typedSettings.getLocalizedValuesMap("emailEntryAddedSubject"),
			"emailEntryAddedSubject");
	}

	@Override
	public String emailEntryUpdatedBodyXml() {
		return LocalizationUtil.getXml(
			_typedSettings.getLocalizedValuesMap("emailEntryUpdatedBody"),
			"emailEntryUpdatedBody");
	}

	@Override
	public String emailEntryUpdatedSubjectXml() {
		return LocalizationUtil.getXml(
			_typedSettings.getLocalizedValuesMap("emailEntryUpdatedSubject"),
			"emailEntryUpdatedSubject");
	}

	@Override
	public long rootFolderId() {
		return _typedSettings.getLongValue(
			"rootFolderId", BookmarksFolderConstants.DEFAULT_PARENT_FOLDER_ID);
	}

	private final TypedSettings _typedSettings;

}