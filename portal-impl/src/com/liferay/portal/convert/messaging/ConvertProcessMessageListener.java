/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.convert.messaging;

import com.liferay.portal.convert.ConvertProcess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.InstancePool;
import com.liferay.portal.util.ShutdownUtil;

/**
 * @author Alexander Chow
 */
public class ConvertProcessMessageListener implements MessageListener {

	@Override
	public void receive(Message message) {
		try {
			doReceive(message);
		}
		catch (Exception exception) {
			_log.fatal("Unable to process message " + message, exception);

			ShutdownUtil.shutdown(0);
		}
	}

	protected void doReceive(Message message) throws Exception {
		String className = (String)message.getPayload();

		ConvertProcess convertProcess = (ConvertProcess)InstancePool.get(
			className);

		convertProcess.convert();
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ConvertProcessMessageListener.class);

}