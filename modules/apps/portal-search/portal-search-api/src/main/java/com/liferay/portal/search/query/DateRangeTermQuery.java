/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.query;

import java.util.TimeZone;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface DateRangeTermQuery extends RangeTermQuery {

	public String getDateFormat();

	public TimeZone getTimeZone();

	public void setDateFormat(String dateFormat);

	public void setTimeZone(TimeZone timeZone);

}