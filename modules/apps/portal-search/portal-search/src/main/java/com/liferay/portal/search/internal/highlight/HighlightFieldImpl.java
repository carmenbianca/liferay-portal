/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.highlight;

import com.liferay.portal.search.highlight.HighlightField;
import com.liferay.portal.search.highlight.HighlightFieldBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Michael C. Han
 */
public class HighlightFieldImpl implements HighlightField {

	public HighlightFieldImpl() {
	}

	public HighlightFieldImpl(HighlightFieldImpl highlightFieldImpl) {
		_fragments.addAll(highlightFieldImpl._fragments);
		_name = highlightFieldImpl._name;
	}

	@Override
	public List<String> getFragments() {
		return Collections.unmodifiableList(_fragments);
	}

	@Override
	public String getName() {
		return _name;
	}

	public static final class HighlightFieldBuilderImpl
		implements HighlightFieldBuilder {

		@Override
		public HighlightFieldBuilder addFragment(String fragment) {
			_highlightFieldImpl._fragments.add(fragment);

			return this;
		}

		@Override
		public HighlightField build() {
			return new HighlightFieldImpl(_highlightFieldImpl);
		}

		@Override
		public HighlightFieldBuilder fragments(Stream<String> fragmentStream) {
			_highlightFieldImpl._fragments = fragmentStream.collect(
				Collectors.toList());

			return this;
		}

		@Override
		public HighlightFieldBuilder name(String name) {
			_highlightFieldImpl._name = name;

			return this;
		}

		private final HighlightFieldImpl _highlightFieldImpl =
			new HighlightFieldImpl();

	}

	private List<String> _fragments = new ArrayList<>();
	private String _name;

}