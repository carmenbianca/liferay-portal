/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.highlight;

import java.util.stream.Stream;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Wade Cao
 * @author André de Oliveira
 */
@ProviderType
public interface HighlightFieldBuilder {

	public HighlightFieldBuilder addFragment(String fragment);

	public HighlightField build();

	public HighlightFieldBuilder fragments(Stream<String> fragmentStream);

	public HighlightFieldBuilder name(String name);

}