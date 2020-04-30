/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation.bucket;

import com.liferay.portal.search.aggregation.FieldAggregation;

/**
 * @author Michael C. Han
 */
public interface GeoHashGridAggregation extends FieldAggregation {

	public Integer getPrecision();

	public Integer getShardSize();

	public Integer getSize();

	public void setPrecision(Integer precision);

	public void setShardSize(Integer shardSize);

	public void setSize(Integer size);

}