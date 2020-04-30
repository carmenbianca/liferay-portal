/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.connection;

/**
 * @author André de Oliveira
 */
public class ElasticsearchConnectionNotInitializedException
	extends IllegalStateException {

	public ElasticsearchConnectionNotInitializedException(String s) {
		super(s);
	}

}