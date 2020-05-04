/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Raymond Augé
 */
public class LARFileException extends PortalException {

	public static final int TYPE_DEFAULT = 0;

	public static final int TYPE_INVALID_MANIFEST = 2;

	public static final int TYPE_MISSING_MANIFEST = 1;

	public LARFileException() {
	}

	public LARFileException(int type) {
		_type = type;
	}

	public LARFileException(int type, String msg) {
		this(msg);

		_type = type;
	}

	public LARFileException(int type, String msg, Throwable cause) {
		this(msg, cause);

		_type = type;
	}

	public LARFileException(int type, Throwable cause) {
		this(cause);

		_type = type;
	}

	public LARFileException(String msg) {
		super(msg);
	}

	public LARFileException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LARFileException(Throwable cause) {
		super(cause);
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	private int _type = TYPE_DEFAULT;

}