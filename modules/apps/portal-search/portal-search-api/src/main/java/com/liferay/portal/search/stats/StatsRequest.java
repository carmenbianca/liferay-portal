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
public interface StatsRequest {

	public String getField();

	public boolean isCardinality();

	public boolean isCount();

	public boolean isMax();

	public boolean isMean();

	public boolean isMin();

	public boolean isMissing();

	public boolean isStandardDeviation();

	public boolean isSum();

	public boolean isSumOfSquares();

}