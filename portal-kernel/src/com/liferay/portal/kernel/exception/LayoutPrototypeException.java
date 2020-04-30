/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.exception;

import com.liferay.portal.kernel.util.Tuple;

import java.util.List;

/**
 * @author Julio Camarero
 */
public class LayoutPrototypeException extends PortalException {

	public LayoutPrototypeException() {
	}

	public LayoutPrototypeException(List<Tuple> missingLayoutPrototypes) {
		_missingLayoutPrototypes = missingLayoutPrototypes;
	}

	public LayoutPrototypeException(String msg) {
		super(msg);
	}

	public LayoutPrototypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public LayoutPrototypeException(Throwable cause) {
		super(cause);
	}

	public List<Tuple> getMissingLayoutPrototypes() {
		return _missingLayoutPrototypes;
	}

	public void setMissingLayoutPrototypes(
		List<Tuple> missingLayoutPrototypes) {

		_missingLayoutPrototypes = missingLayoutPrototypes;
	}

	private List<Tuple> _missingLayoutPrototypes;

}