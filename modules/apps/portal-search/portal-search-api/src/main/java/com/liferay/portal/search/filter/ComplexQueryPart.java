/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.filter;

import com.liferay.portal.search.query.Query;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface ComplexQueryPart {

	public Float getBoost();

	public String getField();

	public String getName();

	public String getOccur();

	public String getParent();

	public Query getQuery();

	public String getType();

	public String getValue();

	public boolean isAdditive();

	public boolean isDisabled();

}