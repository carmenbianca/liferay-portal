/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.antivirus;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.FileUtil;

import java.io.File;
import java.io.IOException;

/**
 * @author Michael C. Han
 */
public abstract class BaseFileAntivirusScanner implements AntivirusScanner {

	@Override
	public boolean isActive() {
		return _ACTIVE;
	}

	@Override
	public void scan(byte[] bytes) throws AntivirusScannerException {
		File file = null;

		try {
			file = FileUtil.createTempFile(_ANTIVIRUS_EXTENSION);

			FileUtil.write(file, bytes);

			scan(file);
		}
		catch (IOException ioException) {
			throw new SystemException(
				"Unable to write temporary file", ioException);
		}
		finally {
			if (file != null) {
				file.delete();
			}
		}
	}

	private static final boolean _ACTIVE = true;

	private static final String _ANTIVIRUS_EXTENSION = "avs";

}