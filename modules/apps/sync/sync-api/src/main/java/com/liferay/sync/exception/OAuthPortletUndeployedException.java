/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Dennis Ju
 */
public class OAuthPortletUndeployedException extends PortalException {

	public OAuthPortletUndeployedException() {
	}

	public OAuthPortletUndeployedException(String msg) {
		super(msg);
	}

	public OAuthPortletUndeployedException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public OAuthPortletUndeployedException(Throwable cause) {
		super(cause);
	}

}