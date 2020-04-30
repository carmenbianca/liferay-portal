/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.rss.model;

/**
 * @author Shuyang Zhou
 */
public interface SyndLink {

	public String getHref();

	public long getLength();

	public String getRel();

	public String getType();

	public void setHref(String href);

	public void setLength(long length);

	public void setRel(String rel);

	public void setType(String type);

}