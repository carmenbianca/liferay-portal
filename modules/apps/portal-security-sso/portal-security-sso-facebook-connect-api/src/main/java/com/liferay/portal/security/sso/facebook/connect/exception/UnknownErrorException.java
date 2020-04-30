/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.facebook.connect.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Stian Sigvartsen
 */
public class UnknownErrorException extends PortalException {

	public UnknownErrorException() {
		super("There was an unknown error");
	}

}