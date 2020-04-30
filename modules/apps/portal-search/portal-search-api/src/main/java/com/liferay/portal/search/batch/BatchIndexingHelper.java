/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.batch;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Bryan Engler
 * @author André de Oliveira
 */
@ProviderType
public interface BatchIndexingHelper {

	public int getBulkSize(String entryClassName);

}