/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.buffer;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface IndexerRequestBufferExecutor {

	public void execute(IndexerRequestBuffer indexerRequestBuffer);

	public void execute(IndexerRequestBuffer indexerRequestBuffer, int count);

}