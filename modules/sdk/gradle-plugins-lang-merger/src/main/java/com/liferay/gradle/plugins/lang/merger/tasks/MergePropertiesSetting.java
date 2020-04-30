/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.lang.merger.tasks;

import java.util.LinkedHashMap;
import java.util.Map;

import org.gradle.util.GUtil;

/**
 * @author Andrea Di Giorgi
 */
public class MergePropertiesSetting {

	public MergePropertiesSetting(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public Map<String, String> getTransformKeys() {
		return _transformKeys;
	}

	public void setTransformKeys(Map<?, ?> transformKeys) {
		_transformKeys.clear();

		transformKeys(transformKeys);
	}

	public MergePropertiesSetting transformKey(
		String sourceKey, String destinationKey) {

		_transformKeys.put(sourceKey, destinationKey);

		return this;
	}

	public MergePropertiesSetting transformKeys(Map<?, ?> transformKeys) {
		GUtil.addToMap(_transformKeys, transformKeys);

		return this;
	}

	private final String _name;
	private final Map<String, String> _transformKeys = new LinkedHashMap<>();

}