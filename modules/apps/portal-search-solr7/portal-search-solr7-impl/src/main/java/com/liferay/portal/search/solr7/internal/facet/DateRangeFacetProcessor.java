/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.facet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(
	immediate = true,
	property = "class.name=com.liferay.portal.kernel.search.facet.DateRangeFacet",
	service = FacetProcessor.class
)
public class DateRangeFacetProcessor extends RangeFacetProcessor {
}