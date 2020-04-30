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
public interface StatsResponse {

	public long getCardinality();

	public long getCount();

	public String getField();

	public double getMax();

	public double getMean();

	public double getMin();

	public long getMissing();

	public double getStandardDeviation();

	public double getSum();

	public double getSumOfSquares();

}