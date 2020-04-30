/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.cdi.extension.internal;

import java.util.List;

/**
 * @author Neil Griffin
 */
public class Preference {

	public Preference(List<String> values, boolean readOnly) {
		_values = values;
		_readOnly = readOnly;
	}

	public List<String> getValues() {
		return _values;
	}

	public boolean isReadOnly() {
		return _readOnly;
	}

	private final boolean _readOnly;
	private final List<String> _values;

}