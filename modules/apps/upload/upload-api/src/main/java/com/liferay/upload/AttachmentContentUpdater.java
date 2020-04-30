/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.upload;

import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;

/**
 * @author Alejandro Tardín
 * @author Jürgen Kappler
 */
public interface AttachmentContentUpdater {

	public String updateContent(
			String content, String contentType,
			UnsafeFunction<FileEntry, FileEntry, PortalException>
				saveTempFileUnsafeFunction)
		throws PortalException;

}