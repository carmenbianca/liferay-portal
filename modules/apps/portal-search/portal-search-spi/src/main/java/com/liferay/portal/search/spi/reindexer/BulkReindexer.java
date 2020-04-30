/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.reindexer;

import java.util.Collection;

/**
 * @author André de Oliveira
 */
public interface BulkReindexer {

	public void reindex(long companyId, Collection<Long> classPKs);

}