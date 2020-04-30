/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import java.util.Map;

import javax.portlet.MutableResourceParameters;

/**
 * @author Neil Griffin
 */
public class MutableResourceParametersImpl
	extends BaseMutablePortletParameters<MutableResourceParameters>
	implements LiferayMutablePortletParameters, MutableResourceParameters {

	public MutableResourceParametersImpl(Map<String, String[]> parameterMap) {
		super(parameterMap, MutableResourceParametersImpl::new);
	}

}