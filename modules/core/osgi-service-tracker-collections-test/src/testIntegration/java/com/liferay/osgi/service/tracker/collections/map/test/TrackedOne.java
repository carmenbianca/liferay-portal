/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.osgi.service.tracker.collections.map.test;

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