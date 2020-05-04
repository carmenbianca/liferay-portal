/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bulk.selection;

import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.util.ResourceBundleLoader;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Adolfo Pérez
 */
public abstract class BaseContainerEntryBulkSelection<T>
	implements BulkSelection<T> {

	public BaseContainerEntryBulkSelection(
		long containerId, Map<String, String[]> parameterMap) {

		_containerId = containerId;
		_parameterMap = parameterMap;
	}

	/**
	 * @deprecated As of Mueller (7.2.x), replaced by {@link
	 *             #BaseContainerEntryBulkSelection(long, Map)}
	 */
	@Deprecated
	public BaseContainerEntryBulkSelection(
		long containerId, Map<String, String[]> parameterMap,
		ResourceBundleLoader resourceBundleLoader, Language language) {

		this(containerId, parameterMap);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return _parameterMap;
	}

	@Override
	public Serializable serialize() {
		return "all:" + _containerId;
	}

	private final long _containerId;
	private final Map<String, String[]> _parameterMap;

}