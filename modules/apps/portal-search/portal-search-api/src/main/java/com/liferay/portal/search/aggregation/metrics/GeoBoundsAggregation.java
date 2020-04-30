/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation.metrics;

import com.liferay.portal.search.aggregation.FieldAggregation;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface GeoBoundsAggregation extends FieldAggregation {

	public Boolean getWrapLongitude();

	public void setWrapLongitude(Boolean wrapLongitude);

}