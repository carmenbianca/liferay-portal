/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.graphql.servlet;

/**
 * @author Preston Crary
 */
public interface ServletData {

	public Object getMutation();

	public String getPath();

	public Object getQuery();

}