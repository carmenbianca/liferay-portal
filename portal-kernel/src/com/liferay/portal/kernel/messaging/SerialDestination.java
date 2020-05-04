/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.messaging;

import com.liferay.petra.lang.CentralizedThreadLocal;
import com.liferay.portal.kernel.cache.thread.local.Lifecycle;
import com.liferay.portal.kernel.cache.thread.local.ThreadLocalCacheManager;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Set;

/**
 * <p>
 * Destination that delivers a message to a list of message listeners one at a
 * time.
 * </p>
 *
 * @author     Michael C. Han
 * @deprecated As of Athanasius (7.3.x), replaced by {@link
 *             com.liferay.portal.messaging.internal.SerialDestination}
 */
@Deprecated
public class SerialDestination extends BaseAsyncDestination {

	public SerialDestination() {
		setWorkersCoreSize(_WORKERS_CORE_SIZE);
		setWorkersMaxSize(_WORKERS_MAX_SIZE);
	}

	@Override
	protected void dispatch(
		final Set<MessageListener> messageListeners, final Message message) {

		final Thread currentThread = Thread.currentThread();

		Runnable runnable = new MessageRunnable(message) {

			@Override
			public void run() {
				try {
					populateThreadLocalsFromMessage(message);

					for (MessageListener messageListener : messageListeners) {
						try {
							messageListener.receive(message);
						}
						catch (MessageListenerException
									messageListenerException) {

							_log.error(
								"Unable to process message " + message,
								messageListenerException);
						}
					}
				}
				finally {
					if (Thread.currentThread() != currentThread) {
						ThreadLocalCacheManager.clearAll(Lifecycle.REQUEST);

						CentralizedThreadLocal.clearShortLivedThreadLocals();
					}
				}
			}

		};

		execute(runnable);
	}

	private static final int _WORKERS_CORE_SIZE = 1;

	private static final int _WORKERS_MAX_SIZE = 1;

	private static final Log _log = LogFactoryUtil.getLog(
		SerialDestination.class);

}