/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.portlet;

import javax.portlet.PortletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class RenderURLTag extends ActionURLTag {

	@Override
	public String getLifecycle() {
		return PortletRequest.RENDER_PHASE;
	}

}