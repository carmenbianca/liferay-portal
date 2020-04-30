/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lpkg.deployer.internal;

import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.petra.lang.SafeClosable;

/**
 * @author Matthew Tambara
 */
public class LPKGBatchInstallThreadLocal {

	public static boolean isBatchInstallInProcess() {
		return _batchInstallInProcess.get();
	}

	public static SafeClosable setBatchInstallInProcess(
		boolean batchInstallInProcess) {

		return _batchInstallInProcess.setWithSafeClosable(
			batchInstallInProcess);
	}

	private static final CentralizedThreadLocal<Boolean>
		_batchInstallInProcess = new CentralizedThreadLocal<>(
			LPKGBatchInstallThreadLocal.class + "._batchInstallInProcess",
			() -> Boolean.FALSE);

}