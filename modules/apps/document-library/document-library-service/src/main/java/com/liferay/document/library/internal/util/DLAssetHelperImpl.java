/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.util;

import com.liferay.document.library.kernel.model.DLFileEntryConstants;
import com.liferay.document.library.util.DLAssetHelper;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(service = DLAssetHelper.class)
public class DLAssetHelperImpl implements DLAssetHelper {

	@Override
	public long getAssetClassPK(FileEntry fileEntry, FileVersion fileVersion) {
		if (fileEntry == null) {
			return 0;
		}

		if (fileVersion == null) {
			return fileEntry.getFileEntryId();
		}

		String version = fileVersion.getVersion();

		if (fileVersion.isApproved() || Validator.isNull(version) ||
			version.equals(DLFileEntryConstants.VERSION_DEFAULT) ||
			fileEntry.isInTrash()) {

			return fileEntry.getFileEntryId();
		}

		return fileVersion.getFileVersionId();
	}

}