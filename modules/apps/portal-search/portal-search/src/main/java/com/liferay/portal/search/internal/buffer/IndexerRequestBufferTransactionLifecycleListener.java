/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.buffer;

import com.liferay.portal.kernel.transaction.TransactionAttribute;
import com.liferay.portal.kernel.transaction.TransactionLifecycleListener;
import com.liferay.portal.kernel.transaction.TransactionStatus;
import com.liferay.portal.search.buffer.IndexerRequestBuffer;
import com.liferay.portal.search.buffer.IndexerRequestBufferExecutor;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = TransactionLifecycleListener.class)
public class IndexerRequestBufferTransactionLifecycleListener
	implements TransactionLifecycleListener {

	@Override
	public void committed(
		TransactionAttribute transactionAttribute,
		TransactionStatus transactionStatus) {

		IndexerRequestBuffer indexerRequestBuffer =
			IndexerRequestBuffer.remove();

		if ((indexerRequestBuffer != null) && !indexerRequestBuffer.isEmpty()) {
			IndexerRequestBufferExecutor indexerRequestBufferExecutor =
				_indexerRequestBufferExecutorWatcher.
					getIndexerRequestBufferExecutor();

			indexerRequestBufferExecutor.execute(indexerRequestBuffer);
		}
	}

	@Override
	public void created(
		TransactionAttribute transactionAttribute,
		TransactionStatus transactionStatus) {

		IndexerRequestBuffer.create();
	}

	@Override
	public void rollbacked(
		TransactionAttribute transactionAttribute,
		TransactionStatus transactionStatus, Throwable throwable) {

		IndexerRequestBuffer indexerRequestBuffer =
			IndexerRequestBuffer.remove();

		if ((indexerRequestBuffer != null) && !indexerRequestBuffer.isEmpty()) {
			indexerRequestBuffer.clear();
		}
	}

	@Reference
	private IndexerRequestBufferExecutorWatcher
		_indexerRequestBufferExecutorWatcher;

}