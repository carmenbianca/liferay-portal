/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.connection;

import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author André de Oliveira
 */
public class IndexName {

	public IndexName(String name) {
		_name = StringUtil.toLowerCase(name);
	}

	public String getName() {
		return _name;
	}

	private final String _name;

}