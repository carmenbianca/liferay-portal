/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.query;

import java.io.Serializable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface Query extends Serializable {

	public <T> T accept(QueryVisitor<T> queryVisitor);

	public Float getBoost();

	public String getQueryName();

	public void setBoost(Float boost);

	public void setQueryName(String queryName);

}