/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.documentlibrary.antivirus;

import com.liferay.document.library.kernel.antivirus.AntivirusScanner;
import com.liferay.document.library.kernel.antivirus.AntivirusScannerWrapper;
import com.liferay.portal.kernel.util.InstancePool;
import com.liferay.portal.util.PropsValues;

/**
 * @author Brian Wing Shun Chan
 */
public class AntivirusScannerImpl extends AntivirusScannerWrapper {

	public AntivirusScannerImpl() {
		super(
			(AntivirusScanner)InstancePool.get(
				PropsValues.DL_STORE_ANTIVIRUS_IMPL));
	}

}