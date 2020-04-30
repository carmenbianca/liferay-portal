/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.internal.messaging.async;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.process.ProcessCallable;

/**
 * @author Shuyang Zhou
 * @author Brian Wing Shun Chan
 */
public class AsyncMessageListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		ProcessCallable<?> processCallable =
			(ProcessCallable<?>)message.getPayload();

		processCallable.call();
	}

}