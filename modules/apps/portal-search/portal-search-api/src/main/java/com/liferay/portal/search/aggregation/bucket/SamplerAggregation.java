/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation.bucket;

import com.liferay.portal.search.aggregation.Aggregation;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface SamplerAggregation extends Aggregation {

	public Integer getShardSize();

	public void setShardSize(Integer shardSize);

}