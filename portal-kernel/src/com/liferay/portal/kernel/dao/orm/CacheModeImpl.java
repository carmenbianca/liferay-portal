/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.orm;

/**
 * @author Brian Wing Shun Chan
 */
public class CacheModeImpl implements CacheMode {

	public CacheModeImpl(String name) {
		_name = name;
	}

	@Override
	public String getName() {
		return _name;
	}

	private final String _name;

}