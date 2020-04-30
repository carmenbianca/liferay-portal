/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.antivirus;

import java.io.File;

/**
 * @author Michael C. Han
 */
public interface AntivirusScanner {

	public boolean isActive();

	public void scan(byte[] bytes) throws AntivirusScannerException;

	public void scan(File file) throws AntivirusScannerException;

}