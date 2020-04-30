/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
public class StructureDuplicateStructureKeyException extends PortalException {

	public StructureDuplicateStructureKeyException() {
	}

	public StructureDuplicateStructureKeyException(String msg) {
		super(msg);
	}

	public StructureDuplicateStructureKeyException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public StructureDuplicateStructureKeyException(Throwable cause) {
		super(cause);
	}

	public String getStructureKey() {
		return _structureKey;
	}

	public void setStructureKey(String structureKey) {
		_structureKey = structureKey;
	}

	private String _structureKey;

}