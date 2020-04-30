/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation.pipeline;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface SerialDiffPipelineAggregation extends PipelineAggregation {

	public String getBucketsPath();

	public String getFormat();

	public GapPolicy getGapPolicy();

	public Integer getLag();

	public void setFormat(String format);

	public void setGapPolicy(GapPolicy gapPolicy);

	public void setLag(Integer lag);

}