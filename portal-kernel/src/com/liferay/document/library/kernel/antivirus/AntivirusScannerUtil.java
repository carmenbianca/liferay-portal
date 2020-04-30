/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.antivirus;

import java.io.File;

/**
 * @author Michael C. Han
 * @author Raymond Augé
 */
public class AntivirusScannerUtil {

	public static AntivirusScanner getAntivirusScanner() {
		return _antivirusScanner;
	}

	public static boolean isActive() {
		AntivirusScanner antivirusScanner = getAntivirusScanner();

		if (antivirusScanner == null) {
			return false;
		}

		return antivirusScanner.isActive();
	}

	public static void scan(byte[] bytes) throws AntivirusScannerException {
		if (isActive()) {
			getAntivirusScanner().scan(bytes);
		}
	}

	public static void scan(File file) throws AntivirusScannerException {
		if (isActive()) {
			getAntivirusScanner().scan(file);
		}
	}

	public void setAntivirusScanner(AntivirusScanner antivirusScanner) {
		_antivirusScanner = antivirusScanner;
	}

	private static AntivirusScanner _antivirusScanner;

}