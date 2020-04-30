/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.integration.internal.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Preston Crary
 */
public class WorkflowLockUtil {

	public static String encodeKey(String name, int version) {
		return name.concat(
			StringPool.POUND
		).concat(
			StringUtil.toHexString(version)
		);
	}

	private WorkflowLockUtil() {
	}

}