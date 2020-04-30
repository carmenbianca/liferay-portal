/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.antivirus;

import java.io.File;

/**
 * @author Brian Wing Shun Chan
 */
public class AntivirusScannerWrapper implements AntivirusScanner {

	public AntivirusScannerWrapper(AntivirusScanner antivirusScanner) {
		_originalAntivirusScanner = antivirusScanner;
		_antivirusScanner = antivirusScanner;
	}

	@Override
	public boolean isActive() {
		return _antivirusScanner.isActive();
	}

	@Override
	public void scan(byte[] bytes) throws AntivirusScannerException {
		_antivirusScanner.scan(bytes);
	}

	@Override
	public void scan(File file) throws AntivirusScannerException {
		_antivirusScanner.scan(file);
	}

	public void setAntivirusScanner(AntivirusScanner antivirusScanner) {
		if (antivirusScanner == null) {
			_antivirusScanner = _originalAntivirusScanner;
		}
		else {
			_antivirusScanner = antivirusScanner;
		}
	}

	private AntivirusScanner _antivirusScanner;
	private final AntivirusScanner _originalAntivirusScanner;

}