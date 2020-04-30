/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.legacy.stats;

import com.liferay.portal.kernel.search.StatsResults;
import com.liferay.portal.search.stats.StatsResponse;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Bryan Engler
 */
@ProviderType
public interface StatsResultsTranslator {

	/**
	 * Creates a legacy {@code StatsResults} object from a {@code StatsResponse}
	 * object.
	 *
	 * @param  statsResponse the {@code StatsResponse} object to be converted
	 * @return the converted legacy {@code StatsResults} object
	 */
	public StatsResults translate(StatsResponse statsResponse);

}