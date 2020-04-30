/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import java.util.Map;

import javax.portlet.MutableActionParameters;

/**
 * @author Neil Griffin
 */
public class MutableActionParametersImpl
	extends BaseMutablePortletParameters<MutableActionParameters>
	implements LiferayMutablePortletParameters, MutableActionParameters {

	public MutableActionParametersImpl(Map<String, String[]> parameterMap) {
		super(parameterMap, MutableActionParametersImpl::new);
	}

}