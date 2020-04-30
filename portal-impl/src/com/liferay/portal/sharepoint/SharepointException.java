/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.sharepoint;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Bruno Farache
 */
public class SharepointException extends PortalException {

	public SharepointException() {
	}

	public SharepointException(String msg) {
		super(msg);
	}

	public SharepointException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SharepointException(Throwable cause) {
		super(cause);
	}

}