/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.internal;

import com.liferay.portal.kernel.portlet.LiferayActionResponse;

import java.io.IOException;

import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderURL;

/**
 * @author Brian Wing Shun Chan
 * @author Neil Griffin
 */
public class ActionResponseImpl
	extends StateAwareResponseImpl implements LiferayActionResponse {

	@Override
	public RenderURL createRedirectURL(MimeResponse.Copy copy) {
		return createRenderURL(copy);
	}

	@Override
	public String getLifecycle() {
		return PortletRequest.ACTION_PHASE;
	}

	@Override
	public void sendRedirect(String location) throws IOException {
		if ((location == null) ||
			(!location.startsWith("/") && !location.contains("://"))) {

			throw new IllegalArgumentException(
				location + " is not a valid redirect");
		}

		if (isCalledSetRenderParameter()) {
			throw new IllegalStateException(
				"Set render parameter has already been called");
		}

		setRedirectLocation(location);
	}

	@Override
	public void sendRedirect(String location, String renderUrlParamName)
		throws IOException {
	}

}