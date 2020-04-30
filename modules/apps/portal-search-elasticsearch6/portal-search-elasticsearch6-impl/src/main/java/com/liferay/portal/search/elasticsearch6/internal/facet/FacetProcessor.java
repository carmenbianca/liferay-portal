/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.facet;

import com.liferay.portal.kernel.search.facet.Facet;

import java.util.Optional;

import org.elasticsearch.search.aggregations.AggregationBuilder;

/**
 * @author Michael C. Han
 */
public interface FacetProcessor<T> {

	public Optional<AggregationBuilder> processFacet(Facet facet);

}