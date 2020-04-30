/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.upload;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;

import java.io.IOException;

/**
 * @author Alejandro Tardín
 */
public interface UploadFileEntryHandler {

	public FileEntry upload(UploadPortletRequest uploadPortletRequest)
		throws IOException, PortalException;

}