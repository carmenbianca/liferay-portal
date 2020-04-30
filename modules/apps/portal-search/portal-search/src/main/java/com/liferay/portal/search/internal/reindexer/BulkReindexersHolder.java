/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.reindexer;

import com.liferay.portal.search.spi.reindexer.BulkReindexer;

/**
 * @author André de Oliveira
 */
public interface BulkReindexersHolder {

	public BulkReindexer getBulkReindexer(String className);

}