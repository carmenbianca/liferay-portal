/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.documentlibrary.antivirus;

import com.liferay.document.library.kernel.antivirus.AntivirusScanner;

import java.io.File;

/**
 * @author Brian Wing Shun Chan
 */
public class DummyAntivirusScannerImpl implements AntivirusScanner {

	@Override
	public boolean isActive() {
		return _ACTIVE;
	}

	@Override
	public void scan(byte[] bytes) {
	}

	@Override
	public void scan(File file) {
	}

	private static final boolean _ACTIVE = false;

}