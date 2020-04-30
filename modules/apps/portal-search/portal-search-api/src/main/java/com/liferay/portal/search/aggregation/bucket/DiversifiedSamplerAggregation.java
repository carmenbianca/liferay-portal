/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation.bucket;

import com.liferay.portal.search.aggregation.FieldAggregation;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DiversifiedSamplerAggregation extends FieldAggregation {

	public String getExecutionHint();

	public Integer getMaxDocsPerValue();

	public Integer getShardSize();

	public void setExecutionHint(String executionHint);

	public void setMaxDocsPerValue(Integer maxDocsPerValue);

	public void setShardSize(Integer shardSize);

}