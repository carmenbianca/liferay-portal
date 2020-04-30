/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.runtime.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.workflow.kaleo.runtime.constants.KaleoRuntimeDestinationNames;

/**
 * @author Michael C. Han
 */
public class SchedulerUtil {

	public static final String getGroupName(long kaleoTimerInstanceTokenId) {
		return KaleoRuntimeDestinationNames.WORKFLOW_TIMER.concat(
			StringPool.SLASH
		).concat(
			String.valueOf(kaleoTimerInstanceTokenId)
		);
	}

}