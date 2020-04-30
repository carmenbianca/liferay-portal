/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.audit;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Michael C. Han
 */
public class AuditException extends PortalException {

	public AuditException() {
	}

	public AuditException(String msg) {
		super(msg);
	}

	public AuditException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AuditException(Throwable cause) {
		super(cause);
	}

}