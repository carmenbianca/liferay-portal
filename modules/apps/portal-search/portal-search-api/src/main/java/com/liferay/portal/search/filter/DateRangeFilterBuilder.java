/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.filter;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface DateRangeFilterBuilder {

	public DateRangeFilter build();

	public void setFieldName(String fieldName);

	public void setFormat(String format);

	public void setFrom(String from);

	public void setIncludeLower(boolean includeLower);

	public void setIncludeUpper(boolean includeUpper);

	public void setTimeZoneId(String timeZoneId);

	public void setTo(String to);

}