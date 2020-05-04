/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.asset.categories.validator;

import com.liferay.asset.kernel.validator.AssetEntryValidatorExclusionRule;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFileVersion;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFileVersionLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(
	property = {
		"model.class.name=com.liferay.document.library.kernel.model.DLFileEntry",
		"model.class.name=com.liferay.portal.kernel.repository.model.FileEntry"
	},
	service = AssetEntryValidatorExclusionRule.class
)
public class ExternalRepositoryAssetEntryValidatorExclusionRule
	implements AssetEntryValidatorExclusionRule {

	@Override
	public boolean isValidationExcluded(
		long groupId, String className, long classPK, long classTypePK,
		long[] categoryIds, String[] tagNames) {

		DLFileEntry dlFileEntry = _getDLFileEntry(classPK);

		if ((dlFileEntry == null) ||
			(dlFileEntry.getRepositoryId() != groupId)) {

			return true;
		}

		return false;
	}

	private DLFileEntry _getDLFileEntry(long classPK) {
		DLFileEntry dlFileEntry = _dlFileEntryLocalService.fetchDLFileEntry(
			classPK);

		if (dlFileEntry != null) {
			return dlFileEntry;
		}

		DLFileVersion dlFileVersion =
			_dlFileVersionLocalService.fetchDLFileVersion(classPK);

		if (dlFileVersion == null) {
			return null;
		}

		return _dlFileEntryLocalService.fetchDLFileEntry(
			dlFileVersion.getFileEntryId());
	}

	@Reference(unbind = "-")
	private DLFileEntryLocalService _dlFileEntryLocalService;

	@Reference(unbind = "-")
	private DLFileVersionLocalService _dlFileVersionLocalService;

}