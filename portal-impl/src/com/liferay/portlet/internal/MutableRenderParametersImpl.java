/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.portlet.MutableRenderParameters;

/**
 * @author Neil Griffin
 */
public class MutableRenderParametersImpl
	extends BaseMutablePortletParameters<MutableRenderParameters>
	implements LiferayMutableRenderParameters {

	public MutableRenderParametersImpl(
		Map<String, String[]> parameterMap,
		Set<String> publicRenderParameterNames) {

		super(
			parameterMap,
			copiedMap -> new MutableRenderParametersImpl(
				copiedMap, publicRenderParameterNames));

		_originalParameterMap = deepCopyMap(parameterMap);
		_publicRenderParameterNames = publicRenderParameterNames;
	}

	@Override
	public void clearPrivate() {
		Map<String, String[]> parameterMap = getParameterMap();

		Set<String> parameterNames = parameterMap.keySet();

		parameterNames.retainAll(_publicRenderParameterNames);
	}

	@Override
	public void clearPublic() {
		Map<String, String[]> parameterMap = getParameterMap();

		Set<String> parameterNames = parameterMap.keySet();

		parameterNames.removeAll(_publicRenderParameterNames);
	}

	@Override
	public boolean isMutated(String name) {
		return !Arrays.equals(_originalParameterMap.get(name), getValues(name));
	}

	@Override
	public boolean isPublic(String name) {
		return _publicRenderParameterNames.contains(name);
	}

	private final Map<String, String[]> _originalParameterMap;
	private final Set<String> _publicRenderParameterNames;

}