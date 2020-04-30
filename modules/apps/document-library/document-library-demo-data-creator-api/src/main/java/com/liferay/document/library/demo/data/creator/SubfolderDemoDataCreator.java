/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.demo.data.creator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.Folder;

/**
 * @author Alejandro Hernández
 */
public interface SubfolderDemoDataCreator extends BaseFolderDemoDataCreator {

	public Folder create(long userId, long parentFolderId)
		throws PortalException;

	public Folder create(long userId, long parentFolderId, String name)
		throws PortalException;

}