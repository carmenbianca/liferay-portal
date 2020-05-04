/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.highlight;

import com.liferay.portal.kernel.search.highlight.HighlightUtil;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = HighlighterTranslator.class)
public class DefaultHighlighterTranslator implements HighlighterTranslator {

	@Override
	public void translate(
		SearchRequestBuilder searchRequestBuilder, String[] highlightFieldNames,
		boolean highlightRequireFieldMatch, int highlightFragmentSize,
		int highlightSnippetSize, boolean luceneSyntax) {

		HighlightBuilder highlightBuilder = new HighlightBuilder();

		for (String highlightFieldName : highlightFieldNames) {
			highlightBuilder.field(
				highlightFieldName, highlightFragmentSize,
				highlightSnippetSize);
		}

		highlightBuilder.postTags(HighlightUtil.HIGHLIGHT_TAG_CLOSE);
		highlightBuilder.preTags(HighlightUtil.HIGHLIGHT_TAG_OPEN);

		if (luceneSyntax) {
			highlightRequireFieldMatch = false;
		}

		highlightBuilder.requireFieldMatch(highlightRequireFieldMatch);

		searchRequestBuilder.highlighter(highlightBuilder);
	}

}