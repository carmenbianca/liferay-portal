/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.uuid;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class PortalUUIDUtil {

	public static String fromJsSafeUuid(String jsSafeUuid) {
		return getPortalUUID().fromJsSafeUuid(jsSafeUuid);
	}

	public static String generate() {
		return getPortalUUID().generate();
	}

	public static String generate(byte[] bytes) {
		return getPortalUUID().generate(bytes);
	}

	public static PortalUUID getPortalUUID() {
		return _portalUUID;
	}

	public static String toJsSafeUuid(String uuid) {
		return getPortalUUID().toJsSafeUuid(uuid);
	}

	public void setPortalUUID(PortalUUID portalUUID) {
		_portalUUID = portalUUID;
	}

	private static PortalUUID _portalUUID;

}