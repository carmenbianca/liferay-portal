/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.query;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DisMaxQuery extends Query {

	public void addQuery(Query query);

	public Set<Query> getQueries();

	public Float getTieBreaker();

	public void setTieBreaker(Float tieBreaker);

}