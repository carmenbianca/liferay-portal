/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation.pipeline;

import com.liferay.portal.search.script.Script;

import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface BucketScriptPipelineAggregation extends PipelineAggregation {

	public void addBucketPath(String paramName, String bucketPath);

	public Map<String, String> getBucketsPathsMap();

	public String getFormat();

	public Script getScript();

	public void setFormat(String format);

}