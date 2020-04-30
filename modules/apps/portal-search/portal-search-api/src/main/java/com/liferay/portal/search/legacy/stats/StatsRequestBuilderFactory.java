/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.legacy.stats;

import com.liferay.portal.kernel.search.Stats;
import com.liferay.portal.search.stats.StatsRequestBuilder;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Bryan Engler
 */
@ProviderType
public interface StatsRequestBuilderFactory {

	/**
	 * Creates a new stats request builder from a legacy {@code Stats} object.
	 *
	 * @param  stats the legacy {@code Stats} object to be converted
	 * @return the converted stats request builder
	 */
	public StatsRequestBuilder getStatsRequestBuilder(Stats stats);

}