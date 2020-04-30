/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import com.liferay.portal.kernel.portlet.LiferayHeaderRequest;

import javax.portlet.PortletRequest;

/**
 * @author Neil Griffin
 */
public class HeaderRequestImpl
	extends RenderRequestImpl implements LiferayHeaderRequest {

	@Override
	public String getLifecycle() {
		return PortletRequest.HEADER_PHASE;
	}

}