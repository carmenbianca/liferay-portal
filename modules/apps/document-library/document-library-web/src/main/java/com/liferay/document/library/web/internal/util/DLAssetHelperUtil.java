/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.util;

import com.liferay.document.library.util.DLAssetHelper;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(service = {})
public class DLAssetHelperUtil {

	public static long getAssetClassPK(
		FileEntry fileEntry, FileVersion fileVersion) {

		DLAssetHelper dlAssetHelper = getDLAssetHelper();

		return dlAssetHelper.getAssetClassPK(fileEntry, fileVersion);
	}

	public static DLAssetHelper getDLAssetHelper() {
		return _dlAssetHelper;
	}

	@Reference(unbind = "-")
	protected void setDLAssetHelper(DLAssetHelper dlAssetHelper) {
		_dlAssetHelper = dlAssetHelper;
	}

	private static DLAssetHelper _dlAssetHelper;

}