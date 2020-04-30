/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.versioning;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;

import java.util.Collection;

/**
 * @author Alejandro Tardín
 */
public interface VersionPurger {

	public Collection<FileVersion> getToPurgeFileVersions(FileEntry fileEntry);

	public interface VersionPurgedListener {

		public void versionPurged(FileVersion fileVersion);

	}

}