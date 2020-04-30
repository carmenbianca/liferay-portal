/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.filter;

/**
 * @author Michael C. Han
 */
public interface Filter {

	public <T> T accept(FilterVisitor<T> filterVisitor);

	public String getExecutionOption();

	public int getSortOrder();

	public Boolean isCached();

	public void setCached(Boolean cached);

	public void setExecutionOption(String executionOption);

}