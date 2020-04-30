/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.uuid;

/**
 * @author Brian Wing Shun Chan
 */
public interface PortalUUID {

	public String fromJsSafeUuid(String jsSafeUuid);

	public String generate();

	public String generate(byte[] bytes);

	public String toJsSafeUuid(String uuid);

}