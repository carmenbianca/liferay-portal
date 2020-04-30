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
public interface PercentileRanksAggregation extends FieldAggregation {

	public Integer getCompression();

	public Integer getHdrSignificantValueDigits();

	public Boolean getKeyed();

	public PercentilesMethod getPercentilesMethod();

	public double[] getValues();

	public void setCompression(Integer compression);

	public void setHdrSignificantValueDigits(Integer hdrSignificantValueDigits);

	public void setKeyed(Boolean keyed);

	public void setPercentilesMethod(PercentilesMethod percentilesMethod);

	public void setValues(double... values);

}