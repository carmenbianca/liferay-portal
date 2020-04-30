/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resiliency;

/**
 * @author Shuyang Zhou
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 */
@Deprecated
public class PortalResiliencyException extends Exception {

	public PortalResiliencyException(String message) {
		super(message);
	}

	public PortalResiliencyException(String message, Throwable cause) {
		super(message, cause);
	}

	public PortalResiliencyException(Throwable cause) {
		super(cause);
	}

}