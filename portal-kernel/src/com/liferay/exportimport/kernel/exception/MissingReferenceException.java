/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.exception;

import com.liferay.exportimport.kernel.lar.MissingReferences;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Julio Camarero
 */
public class MissingReferenceException extends PortalException {

	public MissingReferenceException() {
		_missingReferences = null;
	}

	public MissingReferenceException(MissingReferences missingReferences) {
		_missingReferences = missingReferences;
	}

	public MissingReferenceException(String msg) {
		super(msg);

		_missingReferences = null;
	}

	public MissingReferenceException(String msg, Throwable cause) {
		super(msg, cause);

		_missingReferences = null;
	}

	public MissingReferenceException(Throwable cause) {
		super(cause);

		_missingReferences = null;
	}

	public MissingReferences getMissingReferences() {
		return _missingReferences;
	}

	private final MissingReferences _missingReferences;

}