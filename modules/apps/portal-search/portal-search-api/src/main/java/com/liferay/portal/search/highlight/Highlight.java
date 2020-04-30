/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.highlight;

import com.liferay.portal.search.query.Query;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 * @author André de Oliveira
 */
@ProviderType
public interface Highlight {

	public List<FieldConfig> getFieldConfigs();

	public Boolean getForceSource();

	public String getFragmenter();

	public Integer getFragmentSize();

	public String getHighlighterType();

	public Boolean getHighlightFilter();

	public Query getHighlightQuery();

	public Integer getNumOfFragments();

	public String[] getPostTags();

	public String[] getPreTags();

	public Boolean getRequireFieldMatch();

}