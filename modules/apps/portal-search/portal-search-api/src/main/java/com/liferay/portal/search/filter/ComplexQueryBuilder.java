/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.filter;

import com.liferay.portal.search.query.BooleanQuery;
import com.liferay.portal.search.query.Query;

import java.util.Collection;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface ComplexQueryBuilder {

	public ComplexQueryBuilder addParts(
		Collection<ComplexQueryPart> complexQueryParts);

	public Query build();

	public ComplexQueryBuilder root(BooleanQuery booleanQuery);

}