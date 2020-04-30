/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import java.util.Map;

import javax.portlet.ActionParameters;
import javax.portlet.MutableActionParameters;

/**
 * @author Neil Griffin
 */
public class ActionParametersImpl
	extends BasePortletParametersImpl<MutableActionParameters>
	implements ActionParameters {

	public ActionParametersImpl(
		Map<String, String[]> parameterMap, String namespace) {

		super(parameterMap, namespace, MutableActionParametersImpl::new);
	}

}