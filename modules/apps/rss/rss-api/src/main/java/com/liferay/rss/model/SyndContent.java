/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.rss.model;

/**
 * @author Shuyang Zhou
 */
public interface SyndContent {

	public String getType();

	public String getValue();

	public void setType(String type);

	public void setValue(String value);

}