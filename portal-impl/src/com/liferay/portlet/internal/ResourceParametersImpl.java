/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import java.util.Map;

import javax.portlet.MutableResourceParameters;
import javax.portlet.ResourceParameters;

/**
 * @author Neil Griffin
 */
public class ResourceParametersImpl
	extends BasePortletParametersImpl<MutableResourceParameters>
	implements ResourceParameters {

	public ResourceParametersImpl(
		Map<String, String[]> parameterMap, String namespace) {

		super(parameterMap, namespace, MutableResourceParametersImpl::new);
	}

}