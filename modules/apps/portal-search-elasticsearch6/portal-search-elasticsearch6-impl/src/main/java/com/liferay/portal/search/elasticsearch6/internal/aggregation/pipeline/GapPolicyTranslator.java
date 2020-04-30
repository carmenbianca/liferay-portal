/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.aggregation.pipeline;

import com.liferay.portal.search.aggregation.pipeline.GapPolicy;

import org.elasticsearch.search.aggregations.pipeline.BucketHelpers;

/**
 * @author Michael C. Han
 */
public class GapPolicyTranslator {

	public BucketHelpers.GapPolicy translate(GapPolicy gapPolicy) {
		if (gapPolicy == GapPolicy.INSTANT_ZEROS) {
			return BucketHelpers.GapPolicy.INSERT_ZEROS;
		}
		else if (gapPolicy == GapPolicy.SKIP) {
			return BucketHelpers.GapPolicy.SKIP;
		}
		else {
			throw new IllegalArgumentException(
				"Invalid gap policy" + gapPolicy);
		}
	}

}