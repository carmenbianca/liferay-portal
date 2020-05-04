/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.uad.anonymizer;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.user.associated.data.anonymizer.UADAnonymizer;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(service = UADAnonymizer.class)
public class DLFolderUADAnonymizer extends BaseDLFolderUADAnonymizer {

	@Override
	public void autoAnonymize(
			DLFolder dlFolder, long userId, User anonymousUser)
		throws PortalException {

		dlFolder = dlFolderLocalService.getDLFolder(dlFolder.getFolderId());

		super.autoAnonymize(dlFolder, userId, anonymousUser);
	}

	@Override
	public void delete(DLFolder dlFolder) throws PortalException {
		if (dlFolderLocalService.fetchDLFolder(dlFolder.getFolderId()) !=
				null) {

			super.delete(dlFolder);
		}
	}

}