/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.hits;

import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.highlight.HighlightField;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Wade Cao
 */
@ProviderType
public interface SearchHitBuilder {

	public SearchHitBuilder addHighlightField(HighlightField highlightField);

	public SearchHitBuilder addHighlightFields(
		Collection<HighlightField> highlightFields);

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #addHighlightFields(Collection)}
	 */
	@Deprecated
	public SearchHitBuilder addHighlightFields(
		Stream<HighlightField> highlightFieldStream);

	public SearchHitBuilder addSource(String name, Object value);

	public SearchHitBuilder addSources(Map<String, Object> sourcesMap);

	public SearchHit build();

	public SearchHitBuilder document(Document document);

	public SearchHitBuilder explanation(String explanation);

	public SearchHitBuilder id(String id);

	public SearchHitBuilder matchedQueries(String... matchedQueries);

	public SearchHitBuilder score(float score);

	public SearchHitBuilder version(long version);

}