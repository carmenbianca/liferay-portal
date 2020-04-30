/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.display.context;

import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileShortcut;
import com.liferay.portal.kernel.repository.model.FileVersion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alejandro Tardín
 */
public interface DLDisplayContextProvider {

	public DLEditFileEntryDisplayContext getDLEditFileEntryDisplayContext(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse,
		DLFileEntryType dlFileEntryType);

	public DLEditFileEntryDisplayContext getDLEditFileEntryDisplayContext(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, FileEntry fileEntry);

	public DLViewFileEntryHistoryDisplayContext
		getDLViewFileEntryHistoryDisplayContext(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, FileVersion fileVersion);

	public DLViewFileVersionDisplayContext getDLViewFileVersionDisplayContext(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, FileShortcut fileShortcut);

	public DLViewFileVersionDisplayContext getDLViewFileVersionDisplayContext(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse, FileVersion fileVersion);

}