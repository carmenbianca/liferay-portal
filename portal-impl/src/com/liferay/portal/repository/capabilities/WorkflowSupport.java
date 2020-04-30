/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.repository.capabilities;

import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * @author Iván Zaera
 */
public interface WorkflowSupport {

	public void addFileEntry(
			long userId, FileEntry fileEntry, ServiceContext serviceContext)
		throws PortalException;

	public void checkInFileEntry(
			long userId, FileEntry fileEntry,
			DLVersionNumberIncrease dlVersionNumberIncrease,
			ServiceContext serviceContext)
		throws PortalException;

	public void revertFileEntry(
			long userId, FileEntry fileEntry, ServiceContext serviceContext)
		throws PortalException;

	public void updateFileEntry(
			long userId, FileEntry fileEntry,
			DLVersionNumberIncrease dlVersionNumberIncrease,
			ServiceContext serviceContext)
		throws PortalException;

}