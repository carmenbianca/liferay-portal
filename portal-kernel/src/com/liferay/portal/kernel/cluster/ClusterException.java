/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.cluster;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Shuyang Zhou
 */
public class ClusterException extends PortalException {

	public ClusterException() {
	}

	public ClusterException(String msg) {
		super(msg);
	}

	public ClusterException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ClusterException(Throwable cause) {
		super(cause);
	}

}