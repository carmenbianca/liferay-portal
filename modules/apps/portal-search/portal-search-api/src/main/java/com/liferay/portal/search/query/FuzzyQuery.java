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
public interface FuzzyQuery extends Query {

	public String getField();

	public Float getFuzziness();

	public Integer getMaxEdits();

	public Integer getMaxExpansions();

	public Integer getPrefixLength();

	public String getRewrite();

	public Boolean getTranspositions();

	public String getValue();

	public void setFuzziness(Float fuzziness);

	public void setMaxEdits(Integer maxEdits);

	public void setMaxExpansions(Integer maxExpansions);

	public void setPrefixLength(Integer prefixLength);

	public void setRewrite(String rewrite);

	public void setTranspositions(Boolean transpositions);

}