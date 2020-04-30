/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation.bucket;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface IncludeExcludeClause {

	public String[] getExcludedValues();

	public String getExcludeRegex();

	public String[] getIncludedValues();

	public String getIncludeRegex();

}