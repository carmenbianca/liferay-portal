/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.repository.cmis;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.BaseRepositoryImpl;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.InputStream;

import java.util.List;
import java.util.Map;

/**
 * @author Alexander Chow
 */
public abstract class BaseCmisRepository extends BaseRepositoryImpl {

	public abstract String getLatestVersionId(String objectId);

	public abstract String getObjectName(String objectId)
		throws PortalException;

	public abstract List<String> getObjectPaths(String objectId)
		throws PortalException;

	public abstract boolean isCancelCheckOutAllowable(String objectId)
		throws PortalException;

	public abstract boolean isCheckInAllowable(String objectId)
		throws PortalException;

	public abstract boolean isCheckOutAllowable(String objectId)
		throws PortalException;

	public abstract boolean isSupportsMinorVersions() throws PortalException;

	public abstract FileEntry toFileEntry(String objectId)
		throws PortalException;

	public abstract Folder toFolder(String objectId) throws PortalException;

	public abstract FileEntry updateFileEntry(
			String objectId, String mimeType, Map<String, Object> properties,
			InputStream is, String sourceFileName, long size,
			ServiceContext serviceContext)
		throws PortalException;

}