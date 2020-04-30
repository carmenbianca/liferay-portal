/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.backgroundtask;

import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Michael C. Han
 */
public interface BackgroundTaskStatusMessageTranslator {

	public void translate(
		BackgroundTaskStatus backgroundTaskStatus, Message message);

}