/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.buffer;

import com.liferay.portal.search.buffer.IndexerRequest;
import com.liferay.portal.search.buffer.IndexerRequestBuffer;
import com.liferay.portal.search.buffer.IndexerRequestBufferOverflowHandler;
import com.liferay.portal.search.configuration.IndexerRegistryConfiguration;

/**
 * @author Bryan Engler
 * @author Michael C. Han
 */
public class IndexerRequestBufferHandler {

	public IndexerRequestBufferHandler(
		IndexerRequestBufferOverflowHandler indexerRequestBufferOverflowHandler,
		IndexerRegistryConfiguration indexerRegistryConfiguration) {

		_indexerRequestBufferOverflowHandler =
			indexerRequestBufferOverflowHandler;
		_indexerRegistryConfiguration = indexerRegistryConfiguration;
	}

	public void bufferRequest(
			IndexerRequest indexerRequest,
			IndexerRequestBuffer indexerRequestBuffer)
		throws Exception {

		if (!BufferOverflowThreadLocal.isOverflowMode()) {
			int maxBufferSize = _indexerRegistryConfiguration.maxBufferSize();

			indexerRequestBuffer.add(
				indexerRequest, _indexerRequestBufferOverflowHandler,
				maxBufferSize);
		}
		else {
			indexerRequest.execute();
		}
	}

	private final IndexerRegistryConfiguration _indexerRegistryConfiguration;
	private final IndexerRequestBufferOverflowHandler
		_indexerRequestBufferOverflowHandler;

}