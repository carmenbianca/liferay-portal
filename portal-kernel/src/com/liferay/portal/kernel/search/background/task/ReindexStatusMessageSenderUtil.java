/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.background.task;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Andrew Betts
 */
public class ReindexStatusMessageSenderUtil {

	public static void sendStatusMessage(
		String className, long count, long total) {

		_getReindexStatusMessageSender().sendStatusMessage(
			className, count, total);
	}

	public static void sendStatusMessage(
		String phase, long companyId, long[] companyIds) {

		_getReindexStatusMessageSender().sendStatusMessage(
			phase, companyId, companyIds);
	}

	private static ReindexStatusMessageSender _getReindexStatusMessageSender() {
		return _reindexStatusMessageSender;
	}

	private static volatile ReindexStatusMessageSender
		_reindexStatusMessageSender =
			ServiceProxyFactory.newServiceTrackedInstance(
				ReindexStatusMessageSender.class,
				ReindexStatusMessageSenderUtil.class,
				"_reindexStatusMessageSender", false);

}