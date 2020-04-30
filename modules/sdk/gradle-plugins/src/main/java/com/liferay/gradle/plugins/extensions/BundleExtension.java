/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.extensions;

import java.util.HashMap;

/**
 * @author Raymond Augé
 */
public class BundleExtension extends HashMap<String, Object> {

	public Object instruction(String key, Object value) {
		return put(key, value);
	}

	@Override
	public Object put(String key, Object value) {
		return super.put(key, value);
	}

	private static final long serialVersionUID = 1L;

}