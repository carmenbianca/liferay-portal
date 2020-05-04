/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.query;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface CommonTermsQuery extends Query {

	public String getAnalyzer();

	public Float getCutoffFrequency();

	public String getField();

	public String getHighFreqMinimumShouldMatch();

	public Operator getHighFreqOperator();

	public String getLowFreqMinimumShouldMatch();

	public Operator getLowFreqOperator();

	public String getText();

	public void setAnalyzer(String analyzer);

	public void setCutoffFrequency(Float cutoffFrequency);

	public void setHighFreqMinimumShouldMatch(
		String highFreqMinimumShouldMatch);

	public void setHighFreqOperator(Operator highFreqOperator);

	public void setLowFreqMinimumShouldMatch(String lowFreqMinimumShouldMatch);

	public void setLowFreqOperator(Operator lowFreqOperator);

}