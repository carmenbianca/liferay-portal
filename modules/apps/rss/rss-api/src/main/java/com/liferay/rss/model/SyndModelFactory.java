/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.rss.model;

/**
 * @author Shuyang Zhou
 */
public interface SyndModelFactory {

	public SyndContent createSyndContent();

	public SyndEnclosure createSyndEnclosure();

	public SyndEntry createSyndEntry();

	public SyndFeed createSyndFeed();

	public SyndLink createSyndLink();

}