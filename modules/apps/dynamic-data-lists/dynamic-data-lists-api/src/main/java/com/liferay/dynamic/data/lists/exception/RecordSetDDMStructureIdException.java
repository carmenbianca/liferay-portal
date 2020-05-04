/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Thrown when the system is unable to find the required DDM Structure set for a
 * Record Set.
 *
 * @author Brian Wing Shun Chan
 */
public class RecordSetDDMStructureIdException extends PortalException {

	public RecordSetDDMStructureIdException() {
	}

	public RecordSetDDMStructureIdException(String msg) {
		super(msg);
	}

	public RecordSetDDMStructureIdException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RecordSetDDMStructureIdException(Throwable cause) {
		super(cause);
	}

}