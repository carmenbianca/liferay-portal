/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.background.task.kernel.util.comparator;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Eduardo García
 */
public class BackgroundTaskComparatorFactoryUtil {

	public static OrderByComparator<BackgroundTask>
		getBackgroundTaskOrderByComparator(
			String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		OrderByComparator<BackgroundTask> orderByComparator = null;

		if (orderByCol.equals("completion-date")) {
			orderByComparator = new BackgroundTaskCompletionDateComparator(
				orderByAsc);
		}
		else if (orderByCol.equals("create-date")) {
			orderByComparator = new BackgroundTaskCreateDateComparator(
				orderByAsc);
		}
		else if (orderByCol.equals("name")) {
			orderByComparator = new BackgroundTaskNameComparator(orderByAsc);
		}

		return orderByComparator;
	}

}