/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import com.liferay.portal.kernel.portlet.LiferayRenderRequest;

import javax.portlet.PortletRequest;

/**
 * @author Brian Wing Shun Chan
 * @author Neil Griffin
 */
public class RenderRequestImpl
	extends PortletRequestImpl implements LiferayRenderRequest {

	@Override
	public String getETag() {
		return null;
	}

	@Override
	public String getLifecycle() {
		return PortletRequest.RENDER_PHASE;
	}

}