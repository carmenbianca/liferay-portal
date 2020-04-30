/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.background.task;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Andrew Betts
 */
@ProviderType
public interface ReindexStatusMessageSender {

	public void sendStatusMessage(String className, long count, long total);

	public void sendStatusMessage(
		String state, long searchContext, long[] items);

}