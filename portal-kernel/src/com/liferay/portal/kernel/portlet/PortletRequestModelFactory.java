/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

/**
 * @author Shuyang Zhou
 */
public class PortletRequestModelFactory {

	public PortletRequestModelFactory(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		_portletRequest = portletRequest;
		_portletResponse = portletResponse;
	}

	public PortletRequestModel getPortletRequestModel() {
		if (_portletRequestModel == null) {
			_portletRequestModel = new PortletRequestModel(
				_portletRequest, _portletResponse);
		}

		return _portletRequestModel;
	}

	private final PortletRequest _portletRequest;
	private PortletRequestModel _portletRequestModel;
	private final PortletResponse _portletResponse;

}