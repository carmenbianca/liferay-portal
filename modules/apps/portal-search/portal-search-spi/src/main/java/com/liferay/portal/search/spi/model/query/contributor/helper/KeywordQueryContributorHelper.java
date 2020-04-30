/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.spi.model.query.contributor.helper;

import com.liferay.portal.kernel.search.SearchContext;

import java.util.stream.Stream;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface KeywordQueryContributorHelper {

	public String getClassName();

	public Stream<String> getSearchClassNamesStream();

	public SearchContext getSearchContext();

}