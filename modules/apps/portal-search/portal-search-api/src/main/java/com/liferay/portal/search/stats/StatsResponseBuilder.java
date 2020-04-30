/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.stats;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface StatsResponseBuilder {

	public StatsResponse build();

	public StatsResponseBuilder cardinality(long cardinality);

	public StatsResponseBuilder count(long count);

	public StatsResponseBuilder field(String field);

	public StatsResponseBuilder max(double max);

	public StatsResponseBuilder mean(double mean);

	public StatsResponseBuilder min(double min);

	public StatsResponseBuilder missing(long missing);

	public StatsResponseBuilder standardDeviation(double standardDeviation);

	public StatsResponseBuilder sum(double sum);

	public StatsResponseBuilder sumOfSquares(double sumOfSquares);

}