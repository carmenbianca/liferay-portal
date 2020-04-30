/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.registry.internal;

/**
 * @author Raymond Augé
 */
public class TrackedOne {

	public TrackedOne() {
		_key = null;
	}

	public TrackedOne(String key) {
		_key = key;
	}

	public String getKey() {
		return _key;
	}

	private final String _key;

}