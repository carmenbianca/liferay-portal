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
public interface IdsQuery extends Query {

	public void addIds(String... ids);

	public void addTypes(String... types);

	public Set<String> getIds();

	public Set<String> getTypes();

}