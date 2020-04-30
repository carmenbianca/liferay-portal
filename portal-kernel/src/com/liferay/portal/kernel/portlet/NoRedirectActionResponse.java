/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import javax.portlet.ActionResponse;
import javax.portlet.filter.ActionResponseWrapper;

/**
 * @author Brian Wing Shun Chan
 */
public class NoRedirectActionResponse extends ActionResponseWrapper {

	public NoRedirectActionResponse(ActionResponse actionResponse) {
		super(actionResponse);
	}

	public String getRedirectLocation() {
		return _redirectLocation;
	}

	@Override
	public void sendRedirect(String location) {

		// Disable send redirect

		_redirectLocation = location;
	}

	private String _redirectLocation;

}