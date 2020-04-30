/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation.metrics;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface ExtendedStatsAggregationResult extends StatsAggregationResult {

	public double getStdDeviation();

	public double getSumOfSquares();

	public double getVariance();

	public void setStdDeviation(double stdDeviation);

	public void setSumOfSquares(double sumOfSquares);

	public void setVariance(double variance);

}