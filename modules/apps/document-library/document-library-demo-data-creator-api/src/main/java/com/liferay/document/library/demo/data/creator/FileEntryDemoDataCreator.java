/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.demo.data.creator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;

import java.io.IOException;

/**
 * @author Alejandro Hernández
 */
public interface FileEntryDemoDataCreator {

	public FileEntry create(long userId, long folderId)
		throws IOException, PortalException;

	public FileEntry create(long userId, long folderId, String name)
		throws IOException, PortalException;

	public void delete() throws PortalException;

}