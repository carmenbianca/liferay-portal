/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.convert.documentlibrary;

import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.convert.BaseConvertProcess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Alexander Chow
 */
public class DocumentLibraryExtraSettingsConvertProcess
	extends BaseConvertProcess {

	@Override
	public String getDescription() {
		return "convert-extra-settings-from-documents-and-media-files";
	}

	@Override
	public boolean hasCustomView() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		try {
			return DLFileEntryLocalServiceUtil.hasExtraSettings();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			return false;
		}
	}

	@Override
	protected void doConvert() {
	}

	@Override
	protected String getJspPath() {
		return "/edit_document_library_extra_settings.jsp";
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DocumentLibraryExtraSettingsConvertProcess.class);

}