/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation.bucket;

import com.liferay.portal.search.aggregation.Aggregation;
import com.liferay.portal.search.query.Query;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface FilterAggregation extends Aggregation {

	public Query getFilterQuery();

	public void setFilterQuery(Query query);

}