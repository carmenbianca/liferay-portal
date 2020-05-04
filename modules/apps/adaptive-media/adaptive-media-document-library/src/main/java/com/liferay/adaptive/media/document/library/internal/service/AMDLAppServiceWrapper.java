/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.document.library.internal.service;

import com.liferay.adaptive.media.document.library.internal.util.AMCleanUpOnUpdateAndCheckInThreadLocal;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLAppServiceWrapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

import java.io.File;
import java.io.InputStream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adolfo Pérez
 */
@Component(immediate = true, service = ServiceWrapper.class)
public class AMDLAppServiceWrapper extends DLAppServiceWrapper {

	public AMDLAppServiceWrapper() {
		super(null);
	}

	public AMDLAppServiceWrapper(DLAppService dlAppService) {
		super(dlAppService);
	}

	@Override
	public FileEntry updateFileEntryAndCheckIn(
			long fileEntryId, String sourceFileName, String mimeType,
			String title, String description, String changeLog,
			DLVersionNumberIncrease dlVersionNumberIncrease, File file,
			ServiceContext serviceContext)
		throws PortalException {

		return AMCleanUpOnUpdateAndCheckInThreadLocal.enable(
			() -> super.updateFileEntryAndCheckIn(
				fileEntryId, sourceFileName, mimeType, title, description,
				changeLog, dlVersionNumberIncrease, file, serviceContext));
	}

	@Override
	public FileEntry updateFileEntryAndCheckIn(
			long fileEntryId, String sourceFileName, String mimeType,
			String title, String description, String changeLog,
			DLVersionNumberIncrease dlVersionNumberIncrease, InputStream is,
			long size, ServiceContext serviceContext)
		throws PortalException {

		return AMCleanUpOnUpdateAndCheckInThreadLocal.enable(
			() -> super.updateFileEntryAndCheckIn(
				fileEntryId, sourceFileName, mimeType, title, description,
				changeLog, dlVersionNumberIncrease, is, size, serviceContext));
	}

	@Reference
	private DLAppService _dlAppService;

}