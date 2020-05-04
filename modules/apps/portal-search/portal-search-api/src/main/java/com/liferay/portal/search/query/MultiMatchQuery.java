/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.query;

import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface MultiMatchQuery extends Query {

	public String getAnalyzer();

	public Float getCutOffFrequency();

	public Set<String> getFields();

	public Map<String, Float> getFieldsBoosts();

	public String getFuzziness();

	public MatchQuery.RewriteMethod getFuzzyRewriteMethod();

	public Integer getMaxExpansions();

	public String getMinShouldMatch();

	public Operator getOperator();

	public Integer getPrefixLength();

	public Integer getSlop();

	public Float getTieBreaker();

	public Type getType();

	public Object getValue();

	public MatchQuery.ZeroTermsQuery getZeroTermsQuery();

	public boolean isFieldBoostsEmpty();

	public boolean isFieldsEmpty();

	public Boolean isLenient();

	public void setAnalyzer(String analyzer);

	public void setCutOffFrequency(Float cutOffFrequency);

	public void setFuzziness(String fuzziness);

	public void setFuzzyRewriteMethod(
		MatchQuery.RewriteMethod fuzzyRewriteMethod);

	public void setLenient(Boolean lenient);

	public void setMaxExpansions(Integer maxExpansions);

	public void setMinShouldMatch(String minShouldMatch);

	public void setOperator(Operator operator);

	public void setPrefixLength(Integer prefixLength);

	public void setSlop(Integer slop);

	public void setTieBreaker(Float tieBreaker);

	public void setType(Type type);

	public void setZeroTermsQuery(MatchQuery.ZeroTermsQuery zeroTermsQuery);

	public enum Type {

		BEST_FIELDS, CROSS_FIELDS, MOST_FIELDS, PHRASE, PHRASE_PREFIX

	}

}