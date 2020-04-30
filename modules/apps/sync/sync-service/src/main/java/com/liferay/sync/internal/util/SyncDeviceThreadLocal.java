/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync.internal.util;

import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.sync.model.SyncDevice;

/**
 * @author Shinn Lok
 */
public class SyncDeviceThreadLocal {

	public static SyncDevice getSyncDevice() {
		return _syncDevice.get();
	}

	public static void setSyncDevice(SyncDevice syncDevice) {
		_syncDevice.set(syncDevice);
	}

	private static final ThreadLocal<SyncDevice> _syncDevice =
		new CentralizedThreadLocal<>(
			SyncDeviceThreadLocal.class + "._syncDevice");

}