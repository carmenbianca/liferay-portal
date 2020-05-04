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
public interface BoostingQuery extends Query {

	public Float getNegativeBoost();

	public Query getNegativeQuery();

	public Query getPositiveQuery();

	public void setNegativeBoost(Float negativeBoost);

}